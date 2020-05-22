public void displayAllBooksWrittenByAuthorsOverThisAge(int ageInYears) {
   Iterator<Item> items = getCollectionOfItems().iterator(); 
   while (it.hasNext()) {
      Item item = it.next();
      if(item instanceof Book){
         displayBook((Book)item);
      }
   }
}