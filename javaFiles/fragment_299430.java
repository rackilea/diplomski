public class HTMLPrinter implements Printable{
    private final JEditorPane printPane;

    public HTMLPrinter(JEditorPane editorPane){
        printPane = editorPane;
    }

    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex){
        if (pageIndex >= 1) return Printable.NO_SUCH_PAGE;

        Graphics2D g2d = (Graphics2D)graphics;
        g2d.setClip(0, 0, (int)pageFormat.getImageableWidth(), (int)pageFormat.getImageableHeight());
        g2d.translate((int)pageFormat.getImageableX(), (int)pageFormat.getImageableY());

        RepaintManager rm = RepaintManager.currentManager(printPane);
        boolean doubleBuffer = rm.isDoubleBufferingEnabled();
        rm.setDoubleBufferingEnabled(false);

        printPane.setSize((int)pageFormat.getImageableWidth(), 1);
        printPane.print(g2d);

        rm.setDoubleBufferingEnabled(doubleBuffer);

        return Printable.PAGE_EXISTS;
    }
}