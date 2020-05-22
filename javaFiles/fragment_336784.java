@Override
public void actionPerformed(ActionEvent e) {
  if (e.getSource() == click) {
    res.setText(null);
    System.out.println("Test: "+textv.getText());
    System.out.println("Test: "+text.getText());
    if (textv != null) {
      cercaStringa(pathFile, textv.getText().toString());
    } else {
      cercaStringa(pathFile, text.getText().toString());
    }
  }
}