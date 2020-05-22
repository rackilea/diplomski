public class WeightEvent extends Event {
  public int getWeight() { return(_weight); }
  public int getReps() { return(_reps); }
  public int[] getTempData() {
    return new int[]{
      getFormattedDate()[0],
      getWeight(),
      getReps()
    };
  }
}

public class TimedEvent extends Event {
  public String getTimeInHMS() { return(_timeString); }
  public int[] getTempData() {
    return new int[]{
      getFormattedDate()[0],
      getTimeInHMS()
    };
  }
}

public class RepEvent extends Event {
  public int getReps() { return(_reps); }
  public int[] getTempData() {
    return new int[]{
      getFormattedDate()[0],
      getReps()
    };
  }
}