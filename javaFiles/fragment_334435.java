public class Player {
   private String name;
   private int health;

   public Player(String name, int health) {
      this.name = name;
      this.health = health;
   }

   public String getName() { return name; }

   public int getHealth() { return health; }
}