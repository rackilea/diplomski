AlertDialog dialog;
    AlertDialog.Builder alert;

alert = new AlertDialog.Builder(this);
        alert.setTitle("Select Language");
        alert.setSingleChoiceItems(bhasha, -1,
                new DialogInterface.OnClickListener() { // do your stufe }