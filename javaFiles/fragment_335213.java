Dialog dialog;
switch(id){
    case CONNECTING:
        dialog = new ProgressDialog(this);
        ((ProgressDialog)dialog).setMessage("Connecting");
        dialog.setTitle("");
        return dialog;