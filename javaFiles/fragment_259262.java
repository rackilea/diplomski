public void isCorrectPin(Context context, String title, String message, String btnPositive, final DialogSingleButtonListener dialogSingleButtonListener) {
    final AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context);
    dialogBuilder.setTitle(title);
    dialogBuilder.setMessage(message);
    dialogBuilder.setPositiveButton(btnPositive, new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            if (editText.getText().toString() == getPinCode()){
                dialogSingleButtonListener.onButtonClicked(dialog);
            }
        }
    });

    AlertDialog dialog = dialogBuilder.create();
    dialog.show();
}