public class Player {

   //...
   private String name;

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

}

//...
Player[] playerNumber = new Player[5];
playerNumber[0] = new Player();
playerNumber[0].setName("Red");