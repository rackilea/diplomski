//Create a style. We want a blue dashed line.
    final Style drawStyle = new Style(); //create a Style to use
    drawStyle.setFillColor("white");
    drawStyle.setGraphicName("x");
    drawStyle.setPointRadius(4);
    drawStyle.setStrokeWidth(3);
    drawStyle.setStrokeColor("#66FFFF");
    drawStyle.setStrokeDashstyle("dash");

    //create a StyleMap using the Style
    StyleMap drawStyleMap = new StyleMap(drawStyle);

    //Create PathHanlderOptions using this StyleMap
    PathHandlerOptions phOpt = new PathHandlerOptions();
    phOpt.setStyleMap(drawStyleMap);   

    //Create DrawFeatureOptions and set the PathHandlerOptions (that have the StyleMap, that have the Style we wish)
    DrawFeatureOptions drawFeatureOptions = new DrawFeatureOptions();
    drawFeatureOptions.setHandlerOptions(phOpt);

    PathHandler pathHanlder = new PathHandler();

    // Create the DrawFeature control to draw on the map, and pass the DrawFeatureOptions to control the style of the sketch
    final DrawFeature drawLine = new DrawFeature(vectorLayer, pathHanlder, drawFeatureOptions);
    map.addControl(drawLine);
    drawLine.activate();