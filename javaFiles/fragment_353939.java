public void TempFolderCreator(CommonConfig video,CommonConfig audio){


File videoFolder = new File(Environment.getExternalStorageDirectory() +
        File.separator + video.getFolderName() );
 File audioFolder = new File(Environment.getExternalStorageDirectory() +
        File.separator + audio.getFolderName() );

boolean success = true;
if (!videoFolder .exists()) {
    success = folder.mkdirs();
}
if (!audioFolder .exists()) {
    success = folder.mkdirs();
}
//rest of the code