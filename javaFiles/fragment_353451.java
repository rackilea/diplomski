public void onClick(View v) {

            if(a){
                Intent i = new Intent();
                if(type.equals("x")){
                 showErrorAlert("string");

               }
                else if(type.equals("y")){
                    i = new Intent(Activity1.this, Activity3.class);
                    i.putExtra("label2", var3);
                }

                //startActivity(i);
            }

            else startActivity(new Intent(Activity1.this, Activity4.class));
        }
    });

private void showErrorAlert(String errorMsg){           
    AlertDialog errorDialog = new AlertDialog.Builder(this).create();
    errorDialog.setTitle("title");
    errorDialog.setMessage(errorMsg);
    errorDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "Okay", new  DialogInterface.OnClickListener() {

        @Override
        public void onClick(DialogInterface dialog, int which) {
            // TODO Auto-generated method stub

             Intent i = new Intent(Activity1.this, Activity2.class);
                    i.putExtra("label", var);
                    i.putExtra("label1", var2);
                    startActivity(i);
        }
    });

    errorDialog.show();
}