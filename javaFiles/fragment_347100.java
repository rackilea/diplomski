class Game {
    private static final HashMap<Integer , Game> games = new HashMap<>();

    public static Game getGame(int i){
         if(games.get(i) == null)
             games.put(i , new Game(i));

         return games.get(i);
    }
}