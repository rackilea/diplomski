/* You might want to specify the List type rather than having bare List */
     public static void evaluationOfTrade(List<String> tradeAway,
                                          List<String> playerNames) {

        String playerAway =  tradeAway.get(0);

        if (playerNames.contains(playerAway)) {
            System.out.println("Player found:" + " " + playerAway + " Index is : " + playerNames.indexOf(playerAway));
        }
     }