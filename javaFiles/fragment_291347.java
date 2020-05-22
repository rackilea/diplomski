// Global variable
List<Player> bostonCeltics= new ArrayList<>();

// In your onCreate()
bostonCeltics.add(new Player("Kyrie Irving", "23-Mar-92"));
bostonCeltics.add(new Player("Jayson Tatum", "3-Mar-98"));
bostonCeltics.add(new Player("Gordon Hayward", "23-Mar-90"));

// When creating your intent
moveToDetailIntent.putExtra("player", bostonCeltics.get(position));