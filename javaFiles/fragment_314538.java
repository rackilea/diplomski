// Create a builder
AlertDialog.Builder adb = new AlertDialog.Builder(this);

// Set a title
adb.setTitle(getResources().getString(R.string.alert_label));

// Set the dialogs message
adb.setMessage(validationText.toString());

// Set label and even handling of the "positive button"
// 
// NOTE: If you don't want to do anything here except to close the dlg 
// use the next line instead (you don't have to specifiy an event handler)
// adb.setPositiveButton("Continue", null);

adb.setPositiveButton("Continue",
    new android.content.DialogInterface.OnClickListener() {
    public void onClick(DialogInterface dialog, int arg1) {
       // in this case, don't need to do anything other than close alert
    }
    });

// Show the dialog
adb.show();