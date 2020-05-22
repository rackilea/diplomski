public static interface Callback {
    public void onResult(String result);
}

static MyDialogFragment newInstance(MyDialogFragment.Callback callback) {
    MyDialogFragment f = new MyDialogFragment();

    f.setCallback(callback);

    return f;
}