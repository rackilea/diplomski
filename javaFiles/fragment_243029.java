protected boolean isNetworkConnected() {
    Context ctx = this;
    ConnectivityManager cm = (ConnectivityManager) ctx.getSystemService(Context.CONNECTIVITY_SERVICE);
    NetworkInfo network = cm.getActiveNetworkInfo();
    if (network != null) {
        return network.isAvailable();
    }
    return false;
}