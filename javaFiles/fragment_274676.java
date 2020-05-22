// Caller
  // Solution 1
  public <T extends Resource> Result<T> createResult(T resource) {
    return Result.builder(resource).build();
  }

  // Solution 2
  public <T extends Resource> Result<T> createResult(Class<T> resourceClass) {
    return Result.builder(resourceClass).build();
  }


public class Result<T extends Resource> {

  ...
  //Solution 1
  public static <T2 extends Resource> Builder<T2> builder(T2 instance) {
    return new Builder<T2>();
  }

  // static factory method to get a builder
  // Solution 2
  public static <T2 extends Resource> Builder<T2> builder(Class<T2> clazz) {
    return new Builder<T2>();
  }
  ...