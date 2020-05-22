JDialog d = new JDialog();
d.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
final Icon PENDING = UIManager.getIcon("html.pendingImage");
final Icon MISSING = UIManager.getIcon("html.missingImage");
final JOptionPane optionPane = new JOptionPane("Click a Button",
    JOptionPane.QUESTION_MESSAGE, JOptionPane.YES_NO_OPTION);
optionPane.addPropertyChangeListener(new PropertyChangeListener() {
    @Override
    public void propertyChange(PropertyChangeEvent e) {
        if (e.getPropertyName().equals(JOptionPane.VALUE_PROPERTY)) {
            Integer value = (Integer) e.getNewValue();
            if (value.intValue() == JOptionPane.YES_OPTION) {
                optionPane.setIcon(PENDING);
            } else {
                optionPane.setIcon(MISSING);
            }
        }
    }
});
d.setContentPane(optionPane);
d.pack();
d.setLocationRelativeTo(null);
d.setVisible(true);