if (shouldShowRequestPermission(context, permission)) {
    MY_REQUESTED_DIALOG = true;
    showDialogForPermission(context, messageTitle, messageDetails, permission, requestCode);
} else {
    // Gracefully handle the fact that Location permission will never be granted
}