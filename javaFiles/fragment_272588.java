public Ghost extends Actor {

  private Game game;

  private MovementStrategy strategy;

  private Location location;

  public Ghost(Game game, MovementStrategy strategy) {
    this.game = game;
    this.movementStrategy = strategy;
  }

  // From Actor, I guess
  @Override
  public void act() {
    if (location == null) {
      location = game.addGhost(this);
    }
    move(movementStrategy.getDirection(game, location));
  }

  private void move(Direction direction) {
    location = game.move(this, direction);
  }

}

public interface MovementStrategy {

  public Direction getDirection(Game game, Location location);

}

public class Randy implements MovementStrategy {

  public Direction getDirection(Game game, Location location) {
    return selectRandom(game.getPermittedDirections());
  }

}

// constructing a Ghost with a Randy movement strategy

Game game = new Game();
Ghost ghost = new Ghost(game, new Randy());