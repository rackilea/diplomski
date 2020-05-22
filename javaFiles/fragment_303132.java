frame.setLayout(new MigLayout("insets 10, hidemode 3, debug",
        "[][fill, grow][]", ""));
frame.add(getMeasPanel(), "w 500!");
frame.add(getConfigPanel(), "left, grow");
frame.add(getMinimizeButton(), "right, top, wrap");
frame.add(getPlotPanel(), "spanx 3, grow, wrap, push");