final DrawFeature drawRegularPolygon = new DrawFeature(vectorLayer, new RegularPolygonHandler());
map.addControl(drawRegularPolygon);
drawRegularPolygon.activate();
RegularPolygonHandlerOptions options = new RegularPolygonHandlerOptions();
options.setSides(4);
((RegularPolygonHandler) drawRegularPolygon.getHandler()).setOptions(options);