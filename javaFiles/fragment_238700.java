public ReturnValue executeHttp(Context context) {
    try {
        // ...
    } catch(ConnectionTimeoutException e) {
        Toast t = Toast.makeToast(context, message, duration);
        t.show();
    }
}