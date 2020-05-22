public class PrintTest implements Printable {

    private final int marginTop = 20;
    private final int marginLeft = 10;
    private Font mainFont = new Font("Verdana", Font.PLAIN, 10);
    private Font bigFont = new Font("Verdana", Font.PLAIN, 14);
    private int lines;

    private int headerHeighInLines = 5;
    private int lineH = -1;
    private double pageH = -1;
    private int pages = -1;

    private boolean finish = false;

    public PrintTest() {

        lines = 30;// set the total number of rows we want to print
    }

    public static void main(String[] args) {
        PrinterJob job = PrinterJob.getPrinterJob(); // Use default printer
        job.printDialog();
        PrintTest t = new PrintTest();
        job.setPrintable(t);
        try {
            job.print();
        } catch (PrinterException e) {
            e.printStackTrace();
        }

    }

    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {

        // if printed all pages then no_such_page
        if (pageIndex >= getPages()) {
            return NO_SUCH_PAGE;
        }

        Graphics2D g2 = (Graphics2D) graphics;
        AffineTransform defaultTransform = g2.getTransform();
        if (pageH == -1) {

            pageH = pageFormat.getImageableHeight();

        }
        g2.setFont(mainFont);
        int charW = g2.getFontMetrics().charWidth('T');
        if (lineH == -1) {
            lineH = g2.getFontMetrics().getHeight();
        }

        double curY;

        g2.translate(pageFormat.getImageableX() + marginLeft, curY = pageFormat.getImageableY() + marginTop);

        // if we have the first page we can print a title
        // or a description
        if (pageIndex == 0) {
            g2.translate(0, lineH * headerHeighInLines);
        }

        int[] res = getNumLines(pageIndex);

        for (int i = res[0]; i < res[1]; i++) {
            g2.translate(0, lineH);
            g2.drawString("Print row number #" + i, 0, 0);
        }

        // code to add the page number at footer
        g2.setTransform(defaultTransform);
        g2.drawString("page #" + (pageIndex + 1), (int) (pageFormat.getImageableWidth() - charW * 9),
                (int) (pageFormat.getImageableHeight() - (double) lineH / 2));

        return PAGE_EXISTS;

    }

    /**
     * 
     * @param pageIndex
     * @return an int array with contains two values, the num of row to start
     *         printing and the num of row to finish the printing in the
     *         specific pageindex
     */
    public int[] getNumLines(int pageIndex) {

        int[] res = new int[2];

        if (pageIndex == 0) {
            res[0] = 0;
            res[1] = firstPageLines();
            return res;
        }
        double tmpH = pageH - 2 * marginTop;
        double numlines = (double) (tmpH / lineH);
        res[0] = (int) (firstPageLines() + (pageIndex - 1) * numlines);
        res[1] = (int) Math.min((res[0] + numlines), lines + 1);

        return res;
    }

    public int firstPageLines() {
        double tmpPageH = pageH - 2 * marginTop - lineH * headerHeighInLines;
        // return the minumum of expected lines to print and the total number of
        // lines
        return (int) Math.min((tmpPageH / lineH), lines + 1);
    }

    /**
     * 
     * @return int the total number of pages to print
     */
    public int getPages() {
        if (firstPageLines() >= lines) {
            return 1;
        }
        // we substract the lines in the first page
        // because may will be less than in the number of
        // line in the other pages
        // later we increase the total nubmer of pages with 1 for the first page
        int tmpLines = lines - firstPageLines();

        int[] tmp = getNumLines(1);
        int linePerPage = tmp[1] - tmp[0];
        pages = tmpLines / linePerPage;
        if (tmpLines % linePerPage > 0) {
            pages++;
        }
        pages++;

        return pages;
    }
}