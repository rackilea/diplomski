/**
 * Enumeration describing the four available actions to the agent
 * and methods for decoding a given action from the "bit" string
 * (actually represented using booleans).
 */
public enum Action {
  MOVE_FORWARD, REVERSE, TURN_LEFT, TURN_RIGHT

  Action decodeAction(boolean b1, boolean b2) {
    Action ret;

    if (b1) {
      ret = b2 ? Action.MOVE_FORWARD : Action.TURN_LEFT;
    } else {
      ret = b2 ? Action.TURN_RIGHT : Action.REVERSE;
    }

    return ret;
  }
}

/**
 * Class encapsulating the 32-bit "bit string" represented using booleans.
 * Given the state of the four agent inputs the gene will provide a specific
 * action for the agent to perform.
 */
public class Gene {
  private final boolean[] values = new boolean[32];

  public Action getActionForSensorInputs(boolean wallInFront,
    boolean wallBehind, boolean wallToLeft, boolean wallToRight) {

    int i=0;

    // Encode the four sensor inputs as a single integer value by
    // bitwise-ORing each sensor value with a power of 2.
    // The encoded value will be in the range [0, 15].
    if (wallToRight) {
      i |= 0x01;
    }

    if (wallToLeft) {
      i |= 0x02;
    }

    if (wallBehind) {
      i |= 0x04;
    }

    if (wallInFront) {
      i |= 0x08;
    }

    // The look-up index is i * 2 because each action is encoded as 2
    // booleans.
    int index = i * 2;

    // Retrieve the two action bits from the bit string.
    boolean b1 = this.values[index];
    boolean b2 = this.values[index + 1];

    // Finally decode the action to perform.
    return Action.decodeAction(b1, b2);
  }

  // TODO: Add method to support crossover and mutation with other Genes.
}