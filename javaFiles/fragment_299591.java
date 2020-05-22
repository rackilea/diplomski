case R.id.button3:
    // calculate the value first
    int calculation = 0;
    for (int i=0;i<allEd.size();i++){
        // get the entry
        EditText textField = addEd.get(i);

        try {
            // get the value, as a number
            int numberValue = Integer.parseInt(textField.getText());
            // add it to the calculation
            calculation += numberValue;
        } 
        catch (Exception e){
            // ignore errors if the input is empty or isn't a number
        }
    }

    // now display the result
    final AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
    alertDialog.setTitle("Your calculated GPA");
    alertDialog.setMessage("Your calculated GPA is: " + input/count);
    alertDialog.setButton("Ok", new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int which) {
            alertDialog.dismiss();
        }
    });

    alertDialog.show();
break;