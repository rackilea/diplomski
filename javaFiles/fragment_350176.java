public void actionPerformed(ActionEvent e) {
  JButton src = (JButton) e.getSource();
  if(src.getActionCommand().equals("Yes")) {
    yesCount++;
  } else {
    noCount++;
  }
  label.setText("Difference: " + (yesCount - noCount));
}