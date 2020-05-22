public class Level {
  public void tick();
  public static void tick(Level level);
}

level.tick(); // Safe to call if level can't be null
Level.tick(level); // Safe to call in any case