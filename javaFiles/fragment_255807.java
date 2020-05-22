public class Main {
      Player player1 = new Player(); //You create a new Player
      FightMonster actions = new FightMonster();

      player1 = actions.getHit(player1); //You call the method "getHit" and pass the values of player1
 }

 public class FightMonster {
      //The value of "player" its the same value of "player1" that you pass when you called this method
      public Player getHit(Player player) {
           player.setHp(player.getHp - 10); //You change the hp of the player
           return player; //And return the new value of the player
      }
 }