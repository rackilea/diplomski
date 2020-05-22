if (input.length() != 4) {
  System.out.println("You must enter valid input");
  // Probably do something here. 
}

if(input.equals("help")){
    int commandsSize = commands.size();
    for(int i = 0; i < commandsSize; i++) {
      String value = commands.get(i);
      System.out.println(value);
    }
} else if((input.substring(0, 3)).equals("open")) {
...
}