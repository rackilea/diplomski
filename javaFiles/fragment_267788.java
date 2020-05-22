frame = new JFrame();
// frame.setSize(600, 400);

...

JScrollPane pane = new JScrollPane(
    textfield,
    JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
    JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
// specifying initial size for the
// visible portion of the scroll pane
pane.getViewport().setPreferredSize(new Dimension(320, 200));

frame.add(pane, BorderLayout.CENTER);
frame.add(messagePanel, BorderLayout.SOUTH);
// entire UI sizes around the scroll pane view
frame.pack();
frame.setVisible(true);