public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    private String[] moviePath;

    public ImageAdapter(Context c, String[] path) {

        mContext = c;
        this.moviePath = path;
    }

    public int getCount() {
        return moviePath.length;
    }

    //Needed due to methods being abstract
    public Object getItem(int position) {return null;}
    public long getItemId(int position) {return 0;}

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView = (ImageView) convertView;
        if (imageView == null) {
            // if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(500, 500));
            imageView.setPadding(5, 5, 5, 5);
        } else {
            imageView = (ImageView) convertView;
        }

        //imageView.setImageResource(mThumbIds[position]);
        Picasso.with(getActivity())
                .load(moviePath[position])
                .fit()
                .into(imageView);
        return imageView;
    }
}