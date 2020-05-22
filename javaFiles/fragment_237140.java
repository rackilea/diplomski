public class Knapsack {
  private class State {
    State previousState = null;
    int value = 0;
  }

  public List<Integer> solve(List<Integer> list, int limit) {
    // validate input
    if (limit < 0) {
      throw new IllegalArgumentException();
    }
    if (list == null) {
      throw new IllegalArgumentException();
    }
    for (Integer i: list) {
      if (i == null || i.intValue() <= 0) {
        throw new IllegalArgumentException();
      }
    }

    // if the limit is 12, then 0 through 12 inclusive are valid amounts
    State[] states = new State[limit + 1];
    // the state at position x represents a way of achieving a sum of x
    // if a state is null it means we can't get that sum, for example in your
    // question there's no way to get a sum of 11 with any combination of inputs

    // base state -- we can always get a sum of zero if we just take nothing
    states[0] = new State();

    // build up more states
    for (Integer i: list) {
      // iterate through the states backwards
      // if we iterate forwards we'll encounter any changes we make to the list
      // during the iteration, which has the effect of taking the same number
      // multiple times
      for (int j = limit - i.intValue(); j >= 0; --j) {
        if (states[j] != null) {
          State newState = new State();
          newState.previousState = states[j];
          newState.value = i.intValue();
          states[i.intValue() + j] = newState;
        }
      } 
    }

    // find the best state
    State s = null;
    for (int i = limit; i >= 0; --i) {
      if (states[i] != null) {
        // if all you care about is the best achievable sum, you can just
        // return i here
        s = states[i];
        break;
      }
    }

    // build the list of numbers
    List<Integer> ret = new ArrayList<Integer>();
    while (s.previousState != null) {
      // this will add them backwards, change to add to the beginning of the list
      // to preserve the same order as the input
      ret.add(Integer.valueOf(s.value));
      s = s.previousState;
    }

    return ret;
  }

  public static void main(String[] arg) {
    List<Integer> list = new ArrayList<Integer>();
    for (int i: new int[] { 5, 7, 9 }) {
      list.add(Integer.valueOf(i));
    }
    int limit = 13;

    Knapsack k = new Knapsack();
    System.out.println(k.solve(list, limit));
  }
}