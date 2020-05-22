JTextPane leftDiffPane = diffPane1;
JTextPane rightDiffPane = diffPane2;
JScrollPane spLeft = new JScrollPane(leftDiffPane, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
JScrollPane spRight = new JScrollPane(leftDiffPane, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
spLeft.getHorizontalScrollBar().setModel(spRight.getHorizontalScrollBar().getModel());
spLeft.getVerticalScrollBar().setModel(spRight.getVerticalScrollBar().getModel());

// ...