public abstract class Figure {
    private ColorPicker cpFill;
    private ColorPicker cpLine;
    private EventHandler<MouseEvent> mousePressedHandler;
    private EventHandler<MouseEvent> mouseDraggedHandler;

    public Figur(ColorPicker cpFill, ColorPicker cpLine) {
        this.cpFill = cpFill;
        this.cpLine = cpLine;
    }
}

public class MyRectangle extends Figure {
    private Rectangle rect;

    public MyRectangle(ColorPicker cpFill, ColorPicker cpLine) {
        super(cpFill, cpLine);

        mousePressedHandler = e -> {
            // do something with your rectangle here
        }

        mouseDraggedHandler = e -> {
            // do another thing with your rectangle here
        }

        rect.setOnMousePressed(mousePressedHandler);
        rect.setOnMouseDragged(mouseDraggedHandler);
    }
}

public class MyLine extends Figure {
    private Line line;

    public MyRectangle(ColorPicker cpFill, ColorPicker cpLine) {
        super(cpFill, cpLine);

        mousePressedHandler = e -> {
            // do something with your line here
        }

        mouseDraggedHandler = e -> {
            // do another thing with your line here
        }

        line.setOnMousePressed(mousePressedHandler);
        line.setOnMouseDragged(mouseDraggedHandler);
    }
}