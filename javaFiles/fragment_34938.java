JFileChooser chooser = new JFileChooser();
JComponent panel = new JPanel();
panel.add(new JButton("my dummy Accessory"));
panel.setBackground(Color.RED);
chooser.setAccessory(panel);

JComponent center = null;
BorderLayout layout = (BorderLayout) chooser.getLayout();
for (Component child : chooser.getComponents()) {
    if (BorderLayout.CENTER == layout.getConstraints(child)) {
        center = (JComponent) child;
    }
}
if (center != null)
    center.add(panel, BorderLayout.SOUTH);