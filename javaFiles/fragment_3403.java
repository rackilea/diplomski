public class ImageAdapter extends BaseAdapter {

    private static final String TAG = "ImageAdapter";

    private Context mContext;

    public static final Integer[] TATTOOS = {
        R.drawable.image001, R.drawable.image002,
        R.drawable.image003, R.drawable.image004,
        R.drawable.image005, R.drawable.image006,
        R.drawable.image007, R.drawable.image008,
        R.drawable.image009, R.drawable.image010,
        R.drawable.image011, R.drawable.image012,
        R.drawable.image013, R.drawable.image014,
        R.drawable.image015, R.drawable.image016,
        R.drawable.image017, R.drawable.image018,
        R.drawable.image019, R.drawable.image020,
        R.drawable.image021, R.drawable.image022,
        R.drawable.image023, R.drawable.image024,
        R.drawable.image025, R.drawable.image026,
        R.drawable.image027, R.drawable.image028,
        R.drawable.image029, R.drawable.image030,
        R.drawable.image031, R.drawable.image032,
        R.drawable.image033, R.drawable.image034,
        R.drawable.image035, R.drawable.image036,
        R.drawable.image037, R.drawable.image038,
        R.drawable.image039, R.drawable.image040,
        R.drawable.image041, R.drawable.image042,
        R.drawable.image043, R.drawable.image044,
        R.drawable.image045, R.drawable.image046,
        R.drawable.image047, R.drawable.image048,
        R.drawable.image049, R.drawable.image050
    };

    private Bitmap mHolder = null;
    private static final int CACHE_SIZE = 30 * 1024 * 1024; // 8 MiB cache
    /** Cache to store all decoded images */
    private LruCache<Integer, Bitmap> mBitmapsCache = new LruCache<Integer, Bitmap>(CACHE_SIZE) {

        @Override
        protected int sizeOf(final Integer key, final Bitmap value) {
            return value.getByteCount();
        }

        @Override
        protected void entryRemoved(final boolean evicted, final Integer key, final Bitmap oldValue, final Bitmap newValue) {
            if (!oldValue.equals(mHolder)) {
                oldValue.recycle();
            }
        }
    };

    // Constructor
    public ImageAdapter(Context c){
        mContext = c;
        mHolder = BitmapFactory.decodeResource(c.getResources(), R.drawable.ic_launcher, null);
    }

    @Override
    public int getCount() {
        return TATTOOS.length;
    }

    @Override
    public Object getItem(int position) {
        return TATTOOS[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //This actually is a bad solution, because every time convertView is reused, you will still initialize new ImageView, which is wrong
        //ImageView imageView = new ImageView(this.mContext);
        //new BitmapWorkerTask(imageView).execute(Tattoos[position]);
        //return imageView;

        //Better solution
        ImageView imageView;

        if (convertView == null) {
            imageView = new ImageView(this.mContext);

            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setLayoutParams(new GridView.LayoutParams(300, 300));
        } else {
            imageView = (ImageView) convertView;
            //re-use ImageView that already exists in memory
        }

        final Bitmap itemBitmap = mBitmapsCache.get(TATTOOS[position]);

        if (itemBitmap == null || itemBitmap.isRecycled()) {
            Log.e(TAG, position + " is missed, launch decode for " + TATTOOS[position]);
            imageView.setImageBitmap(mHolder);
            mBitmapsCache.put(TATTOOS[position], mHolder);
            new BitmapWorkerTask(mBitmapsCache, mContext.getResources(), this).execute(TATTOOS[position]);
        } else {
            Log.e(TAG, position + " is here for " + TATTOOS[position]);
            imageView.setImageBitmap(itemBitmap);
        }

        return imageView;
    }

    /** AsyncTask for decoding images from resources */
    static class BitmapWorkerTask extends AsyncTask<Integer, Void, Bitmap> {
        private int data = 0;
        private final LruCache<Integer, Bitmap> mCache;
        private final Resources mRes;
        private final BaseAdapter mAdapter;

        public BitmapWorkerTask(LruCache<Integer, Bitmap> cache, Resources res, BaseAdapter adapter) {
            // nothing to do here
            mCache = cache;
            mRes = res;
            mAdapter = adapter;
        }

        // Decode image in background.
        @Override
        protected Bitmap doInBackground(Integer... params) {
            data = params[0];
            return decodeSampledBitmapFromResource(mRes, data, 300, 300);
        }

        // Once complete, see if ImageView is still around and set bitmap.
        @Override
        protected void onPostExecute(Bitmap bitmap) {
            mCache.put(data, bitmap);
            mAdapter.notifyDataSetChanged();
        }
    }

    public static Bitmap decodeSampledBitmapFromResource(Resources res, int resId,
                                                         int reqWidth, int reqHeight) {

        // First decode with inJustDecodeBounds=true to check dimensions
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, resId, options);

        // Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;
        options.outHeight = 300;
        options.outWidth = 300;
        return BitmapFactory.decodeResource(res, resId, options);
    }

    public static int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {

            // Calculate ratios of height and width to requested height and width
            final int heightRatio = Math.round((float) height / (float) reqHeight);
            final int widthRatio = Math.round((float) width / (float) reqWidth);

            // Choose the smallest ratio as inSampleSize value, this will guarantee
            // a final image with both dimensions larger than or equal to the
            // requested height and width.
            inSampleSize = heightRatio < widthRatio ? heightRatio : widthRatio;
        }

        return inSampleSize;
    }
}