frame.setLayout(new MigLayout("insets 10, hidemode 3, debug",
        // cell constraints are empty in original
        "",
        ""));

// meas should have a fixed size
frame.add(getMeasPanel(), "w 500!");
// the config should get all excess space when growing
frame.add(getConfigPanel(), "left, grow, pushx");
frame.add(getMinimizeButton(), "right, top, wrap");
// remove implicit the pushx
frame.add(getPlotPanel(), "spanx 3, grow, wrap, pushy");