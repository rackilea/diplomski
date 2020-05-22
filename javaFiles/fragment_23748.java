PrinterJob pj = PrinterJob.getPrinterJob();
Book book = new Book();
book.append(new Title(), pj.defaultPage());
book.append(table.getPrintable(...), pj.defaultPage());
book.append(new EndPage(), pj.defaultPage());
pj.setPageable(book);
pj.print();
...
private static class Title implements Printable {

    Font font = new Font("SansSerif", Font.PLAIN, 48);

    @Override
    public int print(Graphics g, PageFormat pf, int pageIndex)
        throws PrinterException {
        Graphics2D g2d = (Graphics2D) g;
        g2d.translate(pf.getImageableX(), pf.getImageableY());
        g2d.setFont(font);
        g2d.setColor(Color.black);
        g2d.drawString("Report", 50, 200);
        return Printable.PAGE_EXISTS;
    }
}