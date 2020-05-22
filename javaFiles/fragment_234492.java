class BoxyTextFieldCell extends JPanel {
    JTextField jTextField;

    BoxyTextFieldCell(int width, int margin) {
        jTextField = new JTextField(width);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(jTextField);
        add(Box.createVerticalStrut(margin));
    }

    @Override
    public Dimension getMaximumSize() {
        Dimension size = super.getMaximumSize();
        size.height = getPreferredSize().height;
        return size;
    }
}

@Override
public void actionPerformed(ActionEvent evt) {
    if (evt.getSource() == btnAddType) {
        panel.add(new BoxyTextFieldCell(20, 10));
        panel.revalidate();
    }
    if (evt.getSource() == btnDeleteField) {
        int lastZIndex = panel.getComponentCount() - 1;
        if (lastZIndex >= 0) {
            panel.remove(lastZIndex);
            panel.revalidate();
        }
    }
    validate();
    panel.repaint();
}