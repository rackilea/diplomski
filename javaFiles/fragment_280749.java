// generic task that redraws the canvas when new data arrives
// (but not more often than 60 times per second).
public abstract class CanvasRedrawTask<T> extends AnimationTimer {
    private final AtomicReference<T> data = new AtomicReference<T>(null);
    private final Canvas canvas;

    public CanvasRedrawTask(Canvas canvas) {
        this.canvas = canvas;
    }

    public void requestRedraw(T dataToDraw) {
        data.set(dataToDraw);
        start(); // in case, not already started
    }

    public void handle(long now) {
        // check if new data is available
        T dataToDraw = data.getAndSet(null);
        if (dataToDraw != null) {
            redraw(canvas.getGraphicsContext2D(), dataToDraw);
        }
    }

    protected abstract void redraw(GraphicsContext context, T data);
}

// somewhere else in your concrete canvas implementation
private final RedrawTask<MyData> task = new RedrawTask<MyData>(this) {
    void redraw(GraphicsContext context, MyData data) {
        // TODO: redraw canvas using context and data
    }
}

// may be called by a different thread
public void onDataReceived(...) {
    // process data / prepare for redraw task
    // ...

    // handover data to redraw task
    task.requestRedraw(dataToDraw);
}