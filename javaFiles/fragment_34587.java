@Override
public void focusGained(FocusEvent fe) {
    if (!(fe.getSource() instanceof JTextField)) return;
    JTextField txt = (JTextField)fe.getSource();
    txt.selectAll();
}