import java.util.Random;

public class Monster {
  // Monster properties
  private String name;
  public int health; //public so that Monsters hitting each other can manipulate health.
  private int damage;

  public int getRandomDamage() {
    return (int)(Math.random() * 5 + 1);
  }

  public void Fight(Monster opponent) {
    while (this.health > 0 && opponent.health > 0) {
      opponent.health -= this.getRandomDamage();
      this.health -= opponent.getRandomDamage();
    }
    if (opponent.health>this.health) {
      System.out.println(this.name + " lost!");
    } else {
      System.out.println(opponent.name + " lost!");
    }
  } 

}