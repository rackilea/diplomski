@Override
public void actionPerformed(ActionEvent e) {
    JButton b = (JButton) e.getSource();
    txt.replaceSelection(b.getActionCommand());

}