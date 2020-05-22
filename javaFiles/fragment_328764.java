public class InternetAvailable {
  private static boolean isInternetAvalable;


  public InternetAvailable(boolean isInternetAvailableParam) {
  isInternetAvailable = isInternetAvailableParam
  }

  @Produce public InternetAvailable isInternetAvailable() {
    return isInternetAvailable;

  }
}