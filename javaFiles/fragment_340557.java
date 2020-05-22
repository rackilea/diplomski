private void startUp() {  
Intent startUp = getIntent();  
String receivedString = startUp.getStringExtra(HOBBIES_STRING);  

if (receivedString != null) {  
    String[] separated = receivedString.split(",");  
    foreach(string sep in seperated){
      switch(sep){
        case "Anime":
          anime.setChecked(true);
          break;
        case "Movies":
          movies.setChecked(true);
          break;
        case "Books":
          books.setChecked(true);
          break;
        case "Games":
          games.setChecked(true);
          break;
      }
    }
  }
}