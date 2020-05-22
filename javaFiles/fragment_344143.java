String capturedImageFilePath = Helper.pathgal(act, mCapturedImageURI);
        bmp = Helper.decodeFile(capturedImageFilePath);
if(bmp != null)
  {
    Helper.showpic(act, id1, bmp);
  } else{
      Toast.makeText(act.getApplicationContext(), "bmp is Null",Toast.LENGTH_SHORT).show();
  }