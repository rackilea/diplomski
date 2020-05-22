@Connect(MyCanvas.class)
public class MyCanvasConnector extends AbstractComponentConnector {    

    @Override
    public Widget getWidget() {
        return (GWTMyCanvasWidget) super.getWidget();
    }

    @Override
    protected Widget createWidget() {
        return GWT.create(GWTMyCanvasWidget.class);
    }
}