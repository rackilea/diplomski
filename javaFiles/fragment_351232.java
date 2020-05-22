public class MyObject {

    private Data data;

    public static class Data {

       private FixturesStrutue[] fixtures;
       private LeagueTable[] leagueTable;

       public static class LeagueTable {
           String team;
           int played, gamesWon, gamesDraw, gameLost, goalsFor, goalsAgainst, 
                   goalsDifference, points;

       }

       public static class FixturesStrutue {
           String member1;
           int member2;

       }
   }
}