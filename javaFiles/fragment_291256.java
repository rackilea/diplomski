public void actionPerformed(ActionEvent evt) {
   List<Integer> list = new ArrayList<Integer>();
   String text = myTextField.getText();
   Scanner scanner = new Scanner(text);
   // to add to a list
   while (scanner.hasNextInt()) {
      list.add(scanner.nextInt());
   }
   scanner.close();

   // now you can iterate through the list to do all sorts of math operations
   // outputField.setText();
}