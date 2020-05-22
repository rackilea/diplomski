JPanel jsp1 = new JPanel();
    JPanel jsp2 = new JPanel();

    JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, true, jsp1, jsp2);

    // splitPane.setOneTouchExpandable(true);
    getContentPane().add(splitPane);

    jsp1.add(new James());
    jsp2.add(new Doris());

    //phone.getContentPane().add(jsp1);
    //phone.getContentPane().add(jsp2);