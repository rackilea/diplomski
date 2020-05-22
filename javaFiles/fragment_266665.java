public static void showToast(final Context ctx, final String msg, int type) {
    if (ctx == null || TextUtils.isEmpty(msg))
        return;
    final int toastType = type == Toast.LENGTH_LONG ? Toast.LENGTH_LONG
            : Toast.LENGTH_SHORT;
    if (Looper.myLooper() == Looper.getMainLooper()) {
        Toast.makeText(ctx, msg, toastType).show();
    } else {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(ctx, msg, toastType).show();
            }
        });
    }
}