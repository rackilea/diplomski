JasperReportBuilder jasperReportBuilder = report()
    .columns(col.column("Order No", "orderNo", type.stringType()),
            col.column("Order Amount", "orderAmount", type.bigDecimalType()))
    .setQuery("SELECT orderNo, orderAmount FROM orders WHERE orderNo=$P{orderNo}",
            QueryLanguage.SQL)
    .setConnection(connection).setDefaultFont(stl.font(DEFAULT_FONT, false, false, 12))
    .addParameter("orderNo", String.class) // Parameter declaration (of String type)
    .setParameter("orderNo", "123456")
    .pageFooter(Components.pageXofY())
    .show();