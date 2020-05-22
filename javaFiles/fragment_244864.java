List<String> elements = ...;//create the list, like A,A,B,B,C,C etc.
Random r = new Random();
for( JButton b : buttons ) {
  //get a random element
  int index = r.nextInt( elements.size() ); //index is between 0 and list size exclusive
  String element = elements.remove( index ); //remove the element which returns it as well
  b.setText( element );
}