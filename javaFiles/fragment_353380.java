public static void evaluationOfTrade(List<String> tradeAway,
                                     List<String> playerNames) {

     String playerAway = tradeAway.get(0);

     for (int i = 0; i < playerNames.size(); i++) {
          if (playerAway.equals(playerNames.get(i))) {
              System.out.println("Player found:" + " " + playerAway + " Index is : " + playerNames.indexOf(playerAway));
          }
     }
}