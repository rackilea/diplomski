//1. Direct: Copy player list into player1 List
List<Player> player1 = new ArrayList<Player>(player);

//2. Indirect using method: Copy player list into player1 List
List<Player> player1 = new ArrayList<Player>();
player1.addAll(player);