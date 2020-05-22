public class CheckConnection {

  public static boolean checkConnection(Activity activity) {
    ConnectivityManager cm =
            (ConnectivityManager) activity.getSystemService(Context.CONNECTIVITY_SERVICE);
    NetworkInfo activeNetwork = null;
    if (cm != null) {
        activeNetwork = cm.getActiveNetworkInfo();
        if (activeNetwork != null &&
                activeNetwork.isConnected()) {
            return true;
        } else {
            MySnackBar.getInstance().showSnackBarForMessage(activity, R.string.connection_check_no_internet);
        }
    }
    return false;
  }

public static boolean checkCon(Context context) {
    ConnectivityManager cm =
            (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
    NetworkInfo activeNetwork = null;
    if (cm != null) {
        activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null &&
                activeNetwork.isConnected();
    }
    return false;
  }
}