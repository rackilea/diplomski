public static class MyPasswordDialog extends DialogFragment {
    public interface MyCallBack {
        public void onResult(boolean b);
    }

    public MyCallBack callBack;

    public MyPasswordDialog(MyCallBack callBack) {
        this.callBack = callBack;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
    // your code

    public void onClick(DialogInterface dialog, int id) {
        EditText passField = (EditText) ((AlertDialog) dialog).findViewById(R.id.password);
        String password = passField.getText().toString();
        if (password.matches(getString(R.string.pass_key))) {
            callBack.onResult(true); // pass false depends on condition
        } else {
        // code
        }
    }

    }

}