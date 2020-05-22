JPanel top = new JPanel();
JPanel bottom = new JPanel();
JSplitPane right = new JSplitPane(JSplitPane.VERTICAL_SPLIT, top, bottom);
JPanel left = new JPanel();
JSplitPane horizontal = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, left, right);
frame.add(horizontal, BorderLayout.CENTER);