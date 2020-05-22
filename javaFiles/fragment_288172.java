public class Publisher {

    List<StrategyGame> games;

    public Publisher() {
        games = new ArrayList<>();
    }

    public void publishGame(String name) {
        games.add(new StrategyGame(name));
    }

    public int getHowManyGamesCreated() {
         return games.size();
    }

}