private  void  requestpermissioncamera()
{
    List<String> permissionsNeeded = new ArrayList<String>();

    final List<String> permissionsList = new ArrayList<String>();
    if (!addPermission(permissionsList, Manifest.permission.ACCESS_FINE_LOCATION))
permissionsNeeded.add("GPS");
    if (!addPermission(permissionsList, Manifest.permission.READ_CONTACTS))
permissionsNeeded.add("Read Contacts");
    if (!addPermission(permissionsList, Manifest.permission.WRITE_CONTACTS))
permissionsNeeded.add("Write Contacts");
    if(!addPermission(permissionsList,Manifest.permission.CAMERA))
permissionsNeeded.add("Camera");
    if(!addPermission(permissionsList, Manifest.permission.ACCESS_NOTIFICATION_POLICY))
permissionsNeeded.add("push Notification");

    if (permissionsList.size() > 0) {
        if (permissionsNeeded.size() > 0) {
        // Need Rationale
        String message = "You need to grant access to " + permissionsNeeded.get(0);
        for (int i = 1; i < permissionsNeeded.size(); i++)
        message = message + ", " + permissionsNeeded.get(i);
        showMessageOKCancel(message,new DialogInterface.OnClickListener() {
           @Override
           public void onClick(DialogInterface dialog, int which) {
               requestPermissions(permissionsList.toArray(new String[permissionsList.size()]), REQUEST_CODE_ASK_MULTIPLE_PERMISSIONS);
                    }
                });
           return;
      }
      requestPermissions(permissionsList.toArray(new String[permissionsList.size()]),REQUEST_CODE_ASK_MULTIPLE_PERMISSIONS);
      return;
}
@Override
public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
    switch (requestCode) {
    case REQUEST_CODE_ASK_MULTIPLE_PERMISSIONS:
    {
    Map<String, Integer> perms = new HashMap<String, Integer>();
    // Initial
    perms.put(Manifest.permission.ACCESS_FINE_LOCATION, PackageManager.PERMISSION_GRANTED);
    perms.put(Manifest.permission.READ_CONTACTS, PackageManager.PERMISSION_GRANTED);
    perms.put(Manifest.permission.WRITE_CONTACTS, PackageManager.PERMISSION_GRANTED);
    perms.put(Manifest.permission.CAMERA, PackageManager.PERMISSION_GRANTED);
    perms.put(Manifest.permission.ACCESS_NOTIFICATION_POLICY, PackageManager.PERMISSION_GRANTED);

    // Fill with results
    for (int i = 0; i < permissions.length; i++)
        perms.put(permissions[i], grantResults[i]);
    // Check for ACCESS_FINE_LOCATION
    if (perms.get(Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED && perms.get(Manifest.permission.READ_CONTACTS) == PackageManager.PERMISSION_GRANTED && perms.get(Manifest.permission.WRITE_CONTACTS) == PackageManager.PERMISSION_GRANTED) 
    {
    // All Permissions Granted
    //    insertDummyContact();
    } else {
    // Permission Denied
    Toast.makeText(MainActivity.this, "Some Permission is Denied", Toast.LENGTH_SHORT)
    .show();
    }
    }
    break;
    default:
    super.onRequestPermissionsResult(requestCode, permissions, grantResults);
}