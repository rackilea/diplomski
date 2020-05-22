toolBar.add(createButton("Zoom In X", ZOOM_IN_DOMAIN_COMMAND));
toolBar.add(createButton("Zoom Out X", ZOOM_OUT_DOMAIN_COMMAND));
…
private JButton createButton(String name, String command) {
    final JButton b = new JButton(name);
    b.setActionCommand(command);
    b.addActionListener(chartPanel);
    return b;
}