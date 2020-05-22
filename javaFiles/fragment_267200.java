BorderStroke borderStroke = region.getBorder().getStrokes().get(0);

region.setBorder(null);
region.setBorder(new Border(new BorderStroke(
        cp.getValue(), borderStroke.getTopStyle(), borderStroke.getRadii(),
        borderStroke.getWidths())));