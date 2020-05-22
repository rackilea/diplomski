public class GreaterCell extends Region {

    public enum Symbol {
        GREATER, EQUAL, LOWER
    }

    private static final double SIDE = 60;
    private final Path path;
    private final Text text;

    private final Symbol top, right, bottom, left;
    private final Rectangle clip;

    public GreaterCell(String number, Symbol top, Symbol right, Symbol bottom, Symbol left) {
        this.top = top;
        this.right = right;
        this.bottom = bottom;
        this.left = left;

        getStyleClass().add("greater-cell");

        path = new Path();
        path.getStyleClass().add("path");

        createPath();

        text = new Text(number);
        text.getStyleClass().add("text");

        getChildren().addAll(path, text);

        clip = new Rectangle(SIDE, SIDE);
        setClip(clip);
    }

    @Override
    protected void layoutChildren() {
        super.layoutChildren();

        resizeRelocate(0, 0, SIDE, SIDE);
        Bounds b = text.getBoundsInParent();
        text.resizeRelocate(SIDE / 2d - b.getWidth() / 2d, SIDE / 2d - b.getHeight() / 2d, SIDE / 2d, SIDE / 2d);
    }
}