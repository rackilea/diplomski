public void actionPerformed(ActionEvent e) {
  if (e.getSource() == click) {
    res.setText("");
    if (!textv.getText().isEmpty()) {
      cercaStringa(pathFile, textv.getText().toString());
    } else {
      cercaStringa(pathFile, text.getText().toString());
    }
  }
}