new AlertDialog.Builder(this)
.setTitle("This is the title")
.setMessage("This is the message")
.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
    public void onClick(DialogInterface dialog, int which) { 
        // when yes is clicked
    }
 })
.setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
    public void onClick(DialogInterface dialog, int which) { 
        // when no is clicked
    }
 })
.setIcon(android.R.drawable.ic_dialog_alert)//pic for the icon
 .show();