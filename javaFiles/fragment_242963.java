boolean personInArray = searchById( person.getId() );

if( !personInArray ) {
  if( people == addressBook.length) {
    //resize the array, since it is full and the person should be added 
  }

  //add the person
  addressBook[people] = person;
  people++;
}