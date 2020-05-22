public void _showhint(View vw)
{
    final Dialog showHintDialog = new Dialog(activity);

    showHintDialog.setContentView(R.layout.custom_dialog);
    showHintDialog.setTitle("How to enter data");

    showHintDialog.show();
}

public void closeDialog(View vw)
{
    final Dialog dialog = new Dialog(this) ;
    Button btnClose = (Button) dialog.findViewById(R.id.button) ;
    btnClose.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            dialog.dismiss();
        }
    });
}