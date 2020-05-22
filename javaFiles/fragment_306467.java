private void customDialogCalistir(){
    dialog = new Dialog(this);
    dialog.setContentView(R.layout.dialog);
    btnDialogCancel = (Button) dialog.findViewById(R.id.btnDialogCancel);
    btnDialogSelect =(Button) dialog.findViewById(R.id.btnDialogSelect);
    etMinute = (EditText) dialog.findViewById(R.id.etMinute);

    btnDialogCancel.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            dialog.dismiss();
        }
    });
    btnDialogSelect.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            dialog.dismiss();
        }
    });
    dialog.show();
}