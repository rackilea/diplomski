com.sun.star.frame.XDesktop xDesktop = null;
// getDesktop() is from
// https://wiki.openoffice.org/wiki/API/Samples/Java/Writer/BookmarkInsertion
xDesktop = getDesktop();
com.sun.star.lang.XComponent xComponent = null;
try {
    xComponent = xDesktop.getCurrentComponent();
    XDrawPagesSupplier xDrawPagesSupplier = 
        (XDrawPagesSupplier)UnoRuntime.queryInterface(
            XDrawPagesSupplier.class, xComponent);
    Object drawPages = xDrawPagesSupplier.getDrawPages();
    XIndexAccess xIndexedDrawPages = (XIndexAccess)
        UnoRuntime.queryInterface(
        XIndexAccess.class, drawPages);
    Object drawPage = xIndexedDrawPages.getByIndex(0);
    XMultiServiceFactory xDrawFactory = 
        (XMultiServiceFactory)UnoRuntime.queryInterface(
            XMultiServiceFactory.class, xComponent);
    Object drawShape = xDrawFactory.createInstance(
        "com.sun.star.drawing.RectangleShape");
    XDrawPage xDrawPage = (XDrawPage)UnoRuntime.queryInterface(
        XDrawPage.class, drawPage);
    XShape xDrawShape = UnoRuntime.queryInterface(XShape.class, drawShape);
    xDrawShape.setSize(new Size(10000, 20000));
    xDrawShape.setPosition(new Point(5000, 5000));
    xDrawPage.add(xDrawShape);

    XText xShapeText = UnoRuntime.queryInterface(XText.class, drawShape);
    XPropertySet xShapeProps = UnoRuntime.queryInterface(
        XPropertySet.class, drawShape);
    xShapeText.setString("DEF");
} catch( Exception e) {
    e.printStackTrace(System.err);
    System.exit(1);
}