StringBuilder countStr= new StringBuilder();
public void actionPerformed(ActionEvent event) {
 count++
 countStr.append(count);
 label.setText("Pushes: " +countStr);
}