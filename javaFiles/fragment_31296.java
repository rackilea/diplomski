import org.checkerframework.checker.nullness.qual.*;

class Example {

  private static void mainMethod(@Nullable String startParam, @Nullable String nextParam) {

    if (! useFinal(startParam)) {
      // do nothing
    } else {
      finalMethod(startParam);
    }
  }

  private static void nextMethod(@NonNull String nextParam) {
    System.out.println(nextParam);
  }

  private static void finalMethod(@NonNull String startParam) {
    System.out.println(startParam);
  }

  @EnsuresNonNullIf(expression="#1", result=true)
  private static boolean useFinal(@Nullable String startParam) {
    if (startParam == null) {
      return false;
    } else {
      return true;
    }
  }

}