@Override
protected void onActivityResult(int requestCode,int resultCode, Intent data) 
{
    super.onActivityResult(requestCode, resultCode, data);
    if (requestCode == CREATE_DIRECTORY_REQUEST_CODE) 
    {
      if (resultCode == Activity.RESULT_OK) {
      int takeFlags = data.getFlags()
                   &
      (Intent.FLAG_GRANT_READ_URI_PERMISSION | Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
      ContentResolver resolver = this.getContentResolver();
      resolver.takePersistableUriPermission(data.getData(),takeFlags);
      archiveUri(data.getData().toString()); //important to save the toString() result, not getPath()
      archiveAuthority(data.getData().getAuthority());
      } 
      else 
      {
            // The user cancelled the request.
      }
    }
}