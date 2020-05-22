if (shouldShowRequestPermission(context, permission)) {
    MY_REQUESTED_DIALOG = true;
    showDialogForPermission(context, messageTitle, messageDetails, permission, requestCode);
} else {
    /* THIS LINE IS STARTING THE INFINITE LOOP */
    requestPermission(context, permission, requestCode); 
}