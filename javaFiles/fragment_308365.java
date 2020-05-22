JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, component1, component2);

    SplitPaneUI spui = split.getUI();
    if (spui instanceof BasicSplitPaneUI) {
        ((BasicSplitPaneUI) spui).getDivider().addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent arg0) {
                if (arg0.getClickCount() == 2) {
                    split.setDividerLocation(0.5);
                }
            }
        });
    }