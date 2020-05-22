private static void assertHasPermissions() 
  {
    // Capture the current state of permissions and check against the
    // requirements.
    ApplicationPermissionsManager apm = ApplicationPermissionsManager.getInstance();
    ApplicationPermissions original = apm.getApplicationPermissions();
    ApplicationPermissions permRequest = new ApplicationPermissions();
    int[] permissions = original.getPermissionKeys();
    for ( int i = 0; i < permissions.length; i++ ) 
    {
      permRequest.addPermission( i );
    }
    apm.invokePermissionsRequest( permRequest );
  }