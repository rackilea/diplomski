public static final int MULTIPLE_PERMISSIONS = 10; // code you want.

 String[] permissions= new String[]{
        Manifest.permission.WRITE_EXTERNAL_STORAGE,
        Manifest.permission.WRITE_EXTERNAL_STORAGE
        };


if (checkPermissions())
         //  permissions  granted.    
          createFolder();
}

private  boolean checkPermissions() {
        int result;
        List<String> listPermissionsNeeded = new ArrayList<>();
        for (String p:permissions) {
            result = ContextCompat.checkSelfPermission(getActivity(),p);
            if (result != PackageManager.PERMISSION_GRANTED) {
                listPermissionsNeeded.add(p);
            }
        }
        if (!listPermissionsNeeded.isEmpty()) {
            ActivityCompat.requestPermissions(this, listPermissionsNeeded.toArray(new String[listPermissionsNeeded.size()]),MULTIPLE_PERMISSIONS );
            return false;
        }
        return true;
    }


@Override
public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
    switch (requestCode) {
        case MULTIPLE_PERMISSIONS:{
            if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                // permissions granted.
                createFolder();

            } else {
                String permissions = "";
                for (String per : permissionsList) {
                    permissions += "\n" + per;
                }
                // permissions list of don't granted permission
            }
            return;
        }
    }
}

private void createFolder()
{
File folder2 = new File(Environment.getExternalStorageDirectory() + "/Android");
        if (!folder2.exists()) {
            folder2.mkdir();
        }


 File folder = new File(Environment.getExternalStorageDirectory() + "/Android/MyFolder");
        boolean success = true;
        if (!folder.exists()) {
            success = folder.mkdir();
        }
}