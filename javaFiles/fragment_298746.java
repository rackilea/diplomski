//GRID VIEW

public class MainActivity extends ActionBarActivity { 

int masterTilePos = 15;
GridView gridview;
ImageAdapter imageAdapter;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    gridview = (GridView) findViewById(R.id.gridview);
    imageAdapter= new ImageAdapter(this);
    gridview.setAdapter(imageAdapter);

    gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

        public void onItemClick(AdapterView<?> parent, View v,
                                int position, long id) {

 //These methods check if a neighboring tile is white, if there is one,  swap() is called

   if(checkUp(position) || checkDown(position) || checkLeft(position) || checkRight(position)) { 

                swap(position);

            }

        }
    });


}


  public void swap(int pos) {

  //This is where I try to switch the images, and seems to be the source of the problem

    int val = imageAdaptor.mThumbIds[masterTilePos];
    imageAdapter.mThumbIds[masterTilePos] = imageAdapter.mThumbIds[pos];
    imageAdapter.mThumbIds[pos] = val;

    imageAdapter.notifyDataSetChanged();
    gridview.invalidateViews();

    masterTilePos = pos;
  }
}

//IMAGE ADAPTER

public class ImageAdapter extends BaseAdapter {

private Context mContext;

public ImageAdapter(Context c) {
    mContext = c;
}

public int getCount() {
    return mThumbIds.length;
}

public Object getItem(int position) {
    return null;
}

public long getItemId(int position) {
    return 0;
}

// create a new ImageView for each item referenced by the Adapter
public View getView(int position, View convertView, ViewGroup parent) {

    ImageView imageView;

    if (convertView == null) {

        // if it's not recycled, initialize some attributes
        DisplayMetrics metrics = mContext.getResources().getDisplayMetrics();

        int width = metrics.widthPixels / 4;
        int height = metrics.heightPixels / 4;

        imageView = new ImageView(mContext);

        imageView.setLayoutParams(new GridView.LayoutParams(width, height));

        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setPadding(1, 1, 1, 1);
    }

    else {
        imageView = (ImageView) convertView;
    }

    imageView.setImageResource(mThumbIds[position]);
    return imageView;
}

// the array containing references to the images

public Integer[] mThumbIds = {
        R.drawable.pic1,
        R.drawable.pic2,
        R.drawable.pic3,
        R.drawable.pic4,
        R.drawable.pic5,
        R.drawable.pic6,
        R.drawable.pic7,
        R.drawable.pic8,
        R.drawable.pic9,
        R.drawable.pic10,
        R.drawable.pic11,
        R.drawable.pic12,
        R.drawable.pic13,
        R.drawable.pic14,
        R.drawable.pic15,
        R.drawable.background
  };
}