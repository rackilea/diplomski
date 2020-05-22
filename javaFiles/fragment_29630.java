public abstract class Check {
  private final List<Check> subChecks = new ArrayList<Check>();

  public Check add(Check subCheck) { subChecks.add(subCheck); return this }

  public void run(Data dataToInspect, List<Error> errors) {
    Error e = check(dataToInspect);
    if (e != null) {
       errors.add(e);
       return;
    }
    for (Check subCheck : subChecks) {
      subCheck.run(dataToInspect, errors);
    }
  }

  // Returns null if dataToInspect is OK.
  public abstract Error check(Data dataToInspect);
}