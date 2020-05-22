public class ImageLoader extends AsyncTask<Object, String, Bitmap> {

private WeakReference<ImageView> mReference;
private View view;
private Bitmap bitmap = null;
public static BitmapDrawable drawable = null;
Context context;
Cursor cursor;
long albumId = cursor.getLong(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.ALBUM_ID));

public ImageLoader(ImageView imageView) {
      mReference = new WeakReference<ImageView>(imageView);
}

@Override
protected Bitmap doInBackground(Object... parameters) { ... your code }

@Override
protected Void onPostExecute(Bitmap bitmap) {
 if(mReference != null) {
    if(bitmap != null) {
     ImageView view = mReference.get();
     // note that this could still return null if the view or the reference has been 
     // garbage collected which it could be since it is a weak reference, so you should
     // always check the status in this case.

     //do what you want with the image view. 
    }
  } 
}