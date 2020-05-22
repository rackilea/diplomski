public String consigna(final OnConfirm confirm){
            final String[] data = new String[1];
            AlertDialog.Builder alert = new AlertDialog.Builder(activity);
            alert.setTitle("Nueva temperatura");
            alert.setMessage("Agrega una nueva temperatura");
            final EditText input = new EditText(activity);
            input.setInputType(InputType.TYPE_CLASS_NUMBER);
            input.setRawInputType(InputType.TYPE_CLASS_NUMBER);
            alert.setView(input);
            alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int whichButton) {
                     data[0] = input.getText().toString();
                    confirm.onConfirm(data[0]);
                }
            });
            alert.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int whichButton) {
                    //Put actions for CANCEL button here, or leave in blank
                }
            });
            alert.show();

            return data[0];
        }


 public interface OnConfirm {
         void onConfirm(String s);
    }