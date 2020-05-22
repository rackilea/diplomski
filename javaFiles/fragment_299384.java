jPanel2a = new JPanel(new BorderLayout());
    jPanel2b = new JPanel(new BorderLayout());
    jPanel3 = new JPanel(new BorderLayout());

    jSplitPane2 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, jPanel2a, jPanel2b);

    jSplitPane3 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, list1, list2);
    jSplitPane4 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, jSplitPane3, jPanel3);

    // panelin icerisine component eklendi
    JLabel lblHelloWorld = new JLabel("Hello World!");
    jPanel2a.add(lblHelloWorld);

//      jSplitPane2.setOneTouchExpandable(true);
        jSplitPane2.setDividerLocation(100);
//
//      jSplitPane3.setOneTouchExpandable(true);
        jSplitPane3.setDividerLocation(150);
//
//      jSplitPane4.setOneTouchExpandable(true);
        jSplitPane4.setDividerLocation(300);

    JPanel card3 = new JPanel(new BorderLayout());
    JPanel card4 = new JPanel(new BorderLayout());
    JPanel card5 = new JPanel(new BorderLayout());
    JPanel card6 = new JPanel(new BorderLayout());
    JPanel card7 = new JPanel(new BorderLayout());
    JPanel card8 = new JPanel(new BorderLayout());

//      card3.add(jSplitPane3);
    card3.add(jSplitPane4,BorderLayout.SOUTH);

    tabbedPane.addTab("Main", jSplitPane2);