ArrayList audio=new ArrayList();
 Cursor c=getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, new String[]{MediaStore.Audio.Media.DISPLAY_NAME}, null, null, null);


while(c.moveToNext())
 {
String name=c.getString(c.getColumnIndex(MediaStore.Audio.Media.DISPLAY_NAME));
audio.add(name);

 }