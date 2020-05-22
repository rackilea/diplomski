public static class MockCombo extends JLabel {

    private JButton arrow;

    public MockCombo() {
        JComboBox box = new JComboBox();
        box.setEditable(true);
        arrow = (JButton) box.getComponent(0);
        setLayout(new BorderLayout());
        add(arrow, BorderLayout.LINE_END);
        setOpaque(true);
    }

}