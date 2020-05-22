public class StateChangingClass {

  private ConditionChecker conditionChecker;

  public StateChangingClass() {
    conditionChecker = StartedChecker.INSTANCE;
  }

  public void start() {
    conditionChecker = StartedChecker.INSTANCE;
  }

  public void end() {
    conditionChecker = EndChecker.INSTANCE;
  }

  public boolean checkCondition(double time) {
    return conditionChecker.check(time);
  }

  interface ConditionChecker {

    boolean check(double time);
  }

  static class StartedChecker implements ConditionChecker {

    public static final ConditionChecker INSTANCE = new StartedChecker();

    @Override
    public boolean check(double time) {
      return (time > 0);
    }
  }

  static class EndChecker implements ConditionChecker {

    public static final ConditionChecker INSTANCE = new EndChecker();

    @Override
    public boolean check(double time) {
      return false;
    }
  }
}