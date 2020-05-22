private Dialog dialog;

@Override
public void onResume() {

    AlertDialog.Builder adb = new AlertDialog.Builder(this);

    LinearLayout llView = new LinearLayout(this);

    Button btnDismiss = new Button(this);
    btnDismiss.setOnClickListener(new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            dialog.dismiss();
        }
    });

    llView.addView(btnDismiss);

    adb.setView(llView);
    dialog = adb.create();
    dialog.show();

    super.onResume();
}