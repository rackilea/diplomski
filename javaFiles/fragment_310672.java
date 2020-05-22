AlertDialog playerDialog;

// Strings to Show In Dialog with Radio Buttons
final CharSequence[] items = {" Zero "," Cross "};

 // Creating and Building the Dialog 
AlertDialog.Builder builder = new AlertDialog.Builder(this);
builder.setTitle("Select Your Player");
builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {
public void onClick(DialogInterface dialog, int item) {
switch(item)
{
case 0:
// Your code when first option selected
break;
case 1:
// Your code when 2nd  option selected
break;
}
playerDialog.dismiss();    
}
});
playerDialog = builder.create();
playerDialog.show();