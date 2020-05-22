boolean isSDPresent = android.os.Environment.getExternalStorageState().equals(android.os.Environment.MEDIA_MOUNTED);

if(isSDPresent){
  // yes SD-card is present
}
else{
 // Sorry
}