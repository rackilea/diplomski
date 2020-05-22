public void actionPerformed(ActionEvent evt) {
   String text = myTextField.getText();
   Scanner scanner = new Scanner(text);
   // to add:
   int sum = 0;
   while (scanner.hasNextInt()) {
      sum += scanner.nextInt();
   }
   scanner.close();
   outputField.setText("Sum: " + sum);
}