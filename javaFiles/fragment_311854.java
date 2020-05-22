textPaneHome.setToolTipText("Home Chat Message Window");
//    textPaneHome.setPreferredSize(new Dimension(200,50));
    textPaneHome.addKeyListener(new MyKeyAdapter());

    scrollPaneHomeText.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
    scrollPaneHomeText.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    scrollPaneHomeText.setPreferredSize(new Dimension(200,50));