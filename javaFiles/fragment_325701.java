public class ShowDialogActivity extends Activity {

@Override
protected void onCreate(Bundle savedInstanceState) {
    // TODO Auto-generated method stub
    super.onCreate(savedInstanceState);

    //
    //Log.d("DEBUG", "showing dialog!");

    Dialog dialog = new Dialog(this);
    dialog.setContentView(R.layout.select_dialog_singlechoice);
    dialog.setTitle("Your Widget Name");
    dialog.setCancelable(true);
    dialog.setCanceledOnTouchOutside(true);
    TextView text = (TextView) dialog.findViewById(R.id.text1);
    text.setText("Message");

    dialog.show();
    //
   dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {

    public void onCancel(DialogInterface arg0) {
        finish();
    }

   });
}

}