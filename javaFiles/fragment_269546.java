public class GWTMyCanvasWidget extends Composite {

public static final String CLASSNAME = "mycomponent";
private static final int FRAMERATE = 30;

public GWTMyCanvasWidget() {
    canvas = Canvas.createIfSupported();
    initWidget(canvas);
    setStyleName(CLASSNAME);
}