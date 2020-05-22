ContentResolver cr;

public AsyncImageSetter(ImageView img, String path, ContentResolver cr) {
     this.img = img;
     this.path = path;
     this.cr = cr;
     }
...

@Override
 protected Void doInBackground(Void... params) {
    try{
         bm = getThumbnail(cr, path);
    }catch(Exception e){}

     return null;
 }

private Bitmap getThumbnail(ContentResolver cr, String path) throws Exception {

    Cursor ca = cr.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[] { MediaStore.MediaColumns._ID }, MediaStore.MediaColumns.DATA + "=?", new String[] {path}, null);
    if (ca != null && ca.moveToFirst()) {
        int id = ca.getInt(ca.getColumnIndex(MediaStore.MediaColumns._ID));
        ca.close();
        return MediaStore.Images.Thumbnails.getThumbnail(cr, id, MediaStore.Images.Thumbnails.MICRO_KIND, null );
    }

    ca.close();
    return null;

}