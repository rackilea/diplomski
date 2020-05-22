...
series2.setMarkerStyle(MarkerStyle.DIAMOND);
series2.setMarkerSize((short)15);
XDDFSolidFillProperties fillMarker = new XDDFSolidFillProperties(XDDFColor.from(new byte[]{(byte)0xFF, (byte)0xFF, 0x00}));
XDDFShapeProperties propertiesMarker = new XDDFShapeProperties();
propertiesMarker.setFillProperties(fillMarker);
chart.getCTChart().getPlotArea().getScatterChartArray(0).getSerArray(1).getMarker()
     .addNewSpPr().set(propertiesMarker.getXmlObject());
...