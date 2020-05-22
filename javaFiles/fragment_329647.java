public class RoundedRectangleTest {
    public static void main(String args[]) {
        Display d = Display.getDefault();
        final Shell shell = new Shell(d);

        LightweightSystem lws = new LightweightSystem(shell);
        final Figure contents = new Figure();
        lws.setContents(contents);
        contents.setLayoutManager(new GridLayout());

        IFigure rectangleFigure = createFigure();
        ScrollPane pane = new ScrollPane();

        /* delete following two lines if scrollbars not always visible */
        pane.setHorizontalScrollBarVisibility(ScrollPane.ALWAYS);
        pane.setVerticalScrollBarVisibility(ScrollPane.ALWAYS);
        pane.setContents(rectangleFigure);
        contents.add(pane);

        shell.open();
        shell.setText("Scrollpane Example");
        while (!shell.isDisposed()) {
            if (!d.readAndDispatch())
                d.sleep();
        }
    }

    private static IFigure createFigure() {
        RectangleFigure rectangleFigure = new RectangleFigure();
        rectangleFigure.setBackgroundColor(ColorConstants.yellow);
        rectangleFigure.setSize(100, 100);
        return rectangleFigure;
    }
}