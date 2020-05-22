private enum Direction { NORTH, SOUTH, EAST, WEST };

public class Agent {
  private final Geneva gene;
  private final int x; // x position in maze;
  private final int y; // y position in maze;
  private Direction currentDirection;

  public double evaluate() {
    double fitness;

    // Perform up to 20 actions and then evaluate fitness.
    for (int i=0; i<20; ++i) {
      // TODO Determine sensor inputs.

      Action action = gene.getActionForSensorInputs(...);

      // TODO: Now apply action to update agent's state.
      // If agent has reached goal exit loop and return fitness 1.0 (max fitness).
      // If agent has exited the maze then exit loop and return 0.0 (min fitness).
    }

    // Calculate fitness after 100 steps taken.  For example could be
    // calculated as sqrt((goal.x - x) ^ 2 + (goal.y - y) ^ 2).

    return fitness;
  }
}