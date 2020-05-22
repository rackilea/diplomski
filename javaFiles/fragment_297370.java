public class MyClass {
  private Map<String, Map<String, Short>> anchorLookup;
  ...
  public void CheckMissingAnchors(...){

    Map<String, Boolean> anchorfound = anchorLookup.keySet()
      .stream()
      .flatMap(s -> anchorlookup.get(s).keySet().stream())
      .collect(Collectors.toMap((s) -> s, (s) -> false);
    ...
  }
}