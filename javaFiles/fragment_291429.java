public class LazyAdapter extends BaseAdapter {

private Activity activity;
private ArrayList path;
private LayoutInflater inflater=null;
public ImageLoader imageLoader; 
DisplayImageOptions options;

public LazyAdapter(Activity a, ArrayList<String> paths) {
    activity = a;
    path = paths;
    inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    File cacheDir = StorageUtils.getOwnCacheDirectory(a, "MyFolderCache");


 // Get singletone instance of ImageLoader
   imageLoader = ImageLoader.getInstance();
 // Create configuration for ImageLoader (all options are optional)
    ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(a)
              // You can pass your own memory cache implementation
             .discCacheExtraOptions(1024, 1024, CompressFormat.PNG, 100)
             .discCache(new UnlimitedDiscCache(cacheDir)) // You can pass your own disc cache implementation
             .discCacheFileNameGenerator(new HashCodeFileNameGenerator())
             .enableLogging()
             .build();
 // Initialize ImageLoader with created configuration. Do it once.
 imageLoader.init(config);
    //imageLoader.init(ImageLoaderConfiguration.createDefault(a));
   // imageLoader=new ImageLoader(activity.getApplicationContext());
    options = new DisplayImageOptions.Builder()
    .showStubImage(R.drawable.ic_launcher)
    .cacheInMemory()
    .cacheOnDisc()
    .displayer(new RoundedBitmapDisplayer(20))
    .build();
}



public int getCount() {
    return path.size();
}

public Object getItem(int position) {
    return position;
}

public long getItemId(int position) {
    return position;
}

public View getView(int position, View convertView, ViewGroup parent) {
    View vi=convertView;
    ViewHolder vh = new ViewHolder();;
    if(convertView==null)
    {

    vi = inflater.inflate(R.layout.row, null);   
    vh.iv=(ImageView)vi.findViewById(R.id.ivv); 
    vh.pb= (ProgressBar)vi.findViewById(R.id.pb); 
    vh.tv = (TextView) vi.findViewById(R.id.textView1);
    vh.tv1= (TextView) vi.findViewById(R.id.textView2);

    }
    vh.tv.setText("Image in postion =");
    vh.tv1.setText(""+position);
    display(vh.iv, data[position], vh.pb);
    //imageLoader.displayImage(path.get(position).toString(), image,options);

    return vi;
}

public void display(ImageView img, String url, final ProgressBar spinner)
{
    imageLoader.displayImage(url, img, options, new ImageLoadingListener() {
        @Override
        public void onLoadingStarted(String imageUri, View view) {
         spinner.setVisibility(View.VISIBLE);
        }
        @Override
        public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
         spinner.setVisibility(View.GONE);


        }
        @Override
        public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
         spinner.setVisibility(View.GONE);
        }
        @Override
        public void onLoadingCancelled(String imageUri, View view) {

        }

});
}
 public static class ViewHolder
 {
  ImageView iv;
  TextView tv,tv1;
  ProgressBar pb;

 }
}