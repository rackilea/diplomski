public static void showDialog(SomeActivity someActivity, final SomeCallback callBack {
    final Dialog dialog = new Dialog(someActivity);

    dialog.setContentView(R.layout.dialog_with_buttons);

    // OK button ...
    Button dialogButtonOk = dialog.findViewById(R.id.btn_ok);
    dialogButtonOk.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            callBack.execute(true);
            dialog.dismiss();
        }
    });

    // Cancel button ...
    Button buttonCancel = dialog.findViewById(R.id.btn_cancel);
    buttonCancel.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            callBack.execute(false);
            dialog.dismiss();
        }
    });

    dialog.show();
}