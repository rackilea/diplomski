Scanner input = new Scanner(System.in);

HashMap<String, Game> games = new HashMap<String, Game>();
HashMap<String, Player> players = new HashMap<String, Player>();

games.put(input.next(), new Game());
players.put(input.next(), new Player());

//do something with game and player properties

System.out.println(games.get("game 1"));
System.out.println(players.get("john"));