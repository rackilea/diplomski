private XYMultipleSeriesRenderer buildRenderer(int[] colors,PointStyle[] styles) 
    {
        XYMultipleSeriesRenderer renderer = new XYMultipleSeriesRenderer();
        setRenderer(renderer, colors, styles);
        return renderer;
    }