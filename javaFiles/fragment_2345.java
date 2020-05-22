public ArrayList<JAmos_Chapter09_exercise_94> searchForPrice( String searchString ) {  
  ArrayList<JAmos_Chapter09_exercise_94> searchResult = new ArrayList<JAmos_Chapter09_exercise_94>( ); 
  //Converts the search string price into a double price.
  double maxPrice = Double.parseDouble(searchString);
  for ( JAmos_Chapter09_exercise_94 currentJAmos_Chapter09_exercise_94 : library ) {
    //If itemPrice < maxPrice, add it to the list.
    if ( currentJAmos_Chapter09_exercise_94.getPrice( ) < maxPrice)
      searchResult.add( currentJAmos_Chapter09_exercise_94 );
  } 
  searchResult.trimToSize( ); 
  return searchResult; 
}