List<JButton> buttons = ...; //temporary list of buttons
Random r = new Random();
for( String element : elements ) {
  //remove a random button from the list and assign it the text
  buttons.remove( r.nextInt( buttons.size() ) ).setText(element);
  buttons.remove( r.nextInt( buttons.size() ) ).setText(element);
}