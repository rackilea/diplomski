static private PageFormat getMinimumMarginPageFormat(PrinterJob printJob) {
    PageFormat pf0 = printJob.defaultPage();
    PageFormat pf1 = (PageFormat) pf0.clone();
    Paper p = pf0.getPaper();
    p.setImageableArea(0, 0,pf0.getWidth(), pf0.getHeight());
    pf1.setPaper(p);
    PageFormat pf2 = printJob.validatePage(pf1);
    return pf2;     
}