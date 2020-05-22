JFreeChart chart = ChartFactory.createXYLineChart(
        "Has to have a wider title than subtitle", // chart title
        "X", // x axis label
        "Y", // y axis label
        dataset, // data
        PlotOrientation.VERTICAL,
        true, // include legend
        true, // tooltips
        false // urls
);

String subtitleText = "This is a test subtitle\nIt is also a test of whether or not newlines work";

TextTitle subtitle = new TextTitle(
        subtitleText, // text
        chart.getTitle().getFont().deriveFont(chart.getTitle().getFont().getSize() * 0.6f), // font (shrunk title)
        chart.getTitle().getPaint(), // paint
        RectangleEdge.TOP, // position
        HorizontalAlignment.LEFT, //chart2.getTitle().DEFAULT_HORIZONTAL_ALIGNMENT, // horizontal alignment
        VerticalAlignment.BOTTOM, // vertical alignment
        chart.getTitle().getPadding() // padding
);

BlockContainer blockContainer = new BlockContainer(new ColumnArrangement(HorizontalAlignment.LEFT, VerticalAlignment.TOP, 0, 0));
blockContainer.add(chart.getTitle());
blockContainer.add(subtitle);
CompositeTitle compositeTitle = new CompositeTitle(blockContainer);
compositeTitle.setPosition(RectangleEdge.TOP);
compositeTitle.setVerticalAlignment(VerticalAlignment.CENTER);
chart.getTitle().setVisible(false);
chart.addSubtitle(compositeTitle);

ChartFrame frame = new ChartFrame("Frame", chart);
frame.pack();
frame.setVisible(true);