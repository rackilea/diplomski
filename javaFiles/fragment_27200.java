Map<String, String> teamPlayers = new HashMap<String, String>();
teamPlayers.put("Team 1", "Player 1");
teamPlayers.put("Team 1", "Player 2");    // --> overwrites Player 2
teamPlayers.put("Team 2", "Player 3");
teamPlayers.put("Team 2", "Player 4");    // --> overwrites Player 3 
System.out.println(teamPlayers);