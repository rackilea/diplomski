private void InitiateCall(){
    int hasCallPermission = ContextCompat.checkSelfPermission(getActivity(),Manifest.permission.READ_PHONE_STATE);
    if (hasCallPermission != PackageManager.PERMISSION_GRANTED){
        requestPermissions(new String[]{Manifest.permission.READ_PHONE_STATE},
                REQUEST_CODE_ASK_PERMISSIONS);
        return;
    }
}