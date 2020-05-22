JLabel[] pics = // Put pictures into labels
JPanel panel = new JPanel();
panel.setLayoutManager(/* FlowLayout if the pics are the same size; GridLayout otherwise? */);
for (JLabel pic : pics) {
    panel.add(pic);
}
JScrollPane scroll = new JScrollPane();
scroll.add(panel);
// Disable the vertical scrollbar
scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);