package twoBalls;

import java.awt.EventQueue;

public class LineRunnable implements Runnable {

    private int total;

    private DrawingPanel drawingPanel;

    public LineRunnable(DrawingPanel drawingPanel) {
        this.drawingPanel = drawingPanel;
        this.total = 240;
    }

    @Override
    public void run() {
        setDrawLine();
        for (int pos = 0; pos <= total; pos++) {
            setPos(pos);
            sleep(50L);
        }
    }

    private void setDrawLine() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                drawingPanel.setDrawLine(true);
                drawingPanel.setTotal(total);
            }
        });
    }

    private void setPos(final int pos) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                drawingPanel.setPos(pos);
            }
        });
    }

    private void sleep(long delay) {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {

        }
    }

}