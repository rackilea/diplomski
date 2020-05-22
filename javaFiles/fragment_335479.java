@Override
public void onClick(DialogInterface dialog, int which) {
    if(callback != null) {
        callback.onDialogButtonClicked(true);
    }
}