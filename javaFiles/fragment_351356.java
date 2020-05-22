public class GameId {
    private String currentGameId;
    private static GameId gameID;

    public static GameId getInstance(){
        if(gameID==null){
            gameID=new GameId();
        }
        return gameID;
    }

    public void setCurrentGameId(String id){
        currentGameId=id;
    }

    public String getCurrentGameId(){
        return currentGameId;
    }

    public void game_id() {
        String currentURL = Drivers.getDriver().getCurrentUrl();
        String[] arrayURL = currentURL.split("/");
        int arrLength = arrayURL.length;
        final String gameID;
        gameID = arrayURL[arrLength - 1];
        System.out.println(gameID);
        this.currentGameId=gameID;

    }
}