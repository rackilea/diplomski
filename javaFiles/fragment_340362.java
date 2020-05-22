StorageReference filepath=mStorage.child(uri.getLastPathSegment());

  filepath.putFile(uri).addOnSuccessListener(new 
  OnSuccessListener<UploadTask.TaskSnapshot>() {
   @Override                                                                         
public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

String downloaduri=taskSnapshot.getDownloadUrl().toString();