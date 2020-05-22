public class Player extends GameObject {

  protected static Equipment equipped = new Equipment();
  protected static Species species = new Species();
  protected Specie human = species.getBasicHuman();
  protected int maxHealth;
  protected int speed;
  protected int str;
  protected Double luck;
  protected int def;
  protected int currentHealth;
  protected int wealth;

  Inventory inv = new Inventory();

  public Player() {
    super(Player.nameSetter(), "Player Controlled", System.getProperty("user.dir") + "src\\main\\java\\cz\\com\\GameFiles\\LevyBuild\\Sprites\\Objects\\Items\\Misc\\BearClaw.png");
    properties();
  }
}