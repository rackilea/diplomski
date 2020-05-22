private static class Image implements Printable {…}
private static class Title implements Printable {…}

PrinterJob pj = PrinterJob.getPrinterJob();
Book book = new Book();
book.append(new Image(), pj.defaultPage());
book.append(new Title(), pj.defaultPage());
book.append(table.getPrintable(...), pj.defaultPage());
book.append(new EndPage(), pj.defaultPage());
pj.setPageable(book);
pj.print();