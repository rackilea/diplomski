@Override
public void actionPerformed(ActionEvent e) {
    String value = (JButton) e.getSource().getText();
    txt.setText(txt.getText() + value);

}