public class ExpensiveStrategy {
  public void expensiveMethod() {
    // ...
    if (employOptimization()) {
      // take a shortcut
    }
  }

  protected boolean employOptimization() {
    return false;
  }
}

public class TargetedStrategy extends ExpensiveStrategy {
  @Override
  protected boolean employOptimization() {
    return true; // Now we can shortcut ExpensiveStrategy.
  }
}