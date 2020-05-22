public void disp(Player player1, Player player2){
     System.out.println("Player name: " + player1.getName());
     System.out.println("Player name 2: " + player2.getName());

     player1.setName("Joe?");
     player2.setName("Billy?");

     System.out.println("Player new name: " + player1.getName());
     System.out.println("Player new name 2: " + player2.getName());
}