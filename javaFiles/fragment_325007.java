public class FriendAdapter extends ArrayAdapter<FriendBean>{
private Context mCtx;
private ArrayList<FriendBean> items = new ArrayList<FriendBean>();
private ViewHolder mHolder;
ImageLoader imgLoader = new ImageLoader(mCtx);
public LayoutInflater inflater;
int loader = R.drawable.loader;

public FriendAdapter(Context context,  int textViewResourceId,  ArrayList<FriendBean> items) {
    super(context,  textViewResourceId, items);
    this.items = items;
    this.mCtx = context;

}

@Override
public View getView(int position, View convertView, ViewGroup parent) {
    View v = convertView;

    if (v == null) {
        LayoutInflater vi = (LayoutInflater) mCtx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v=vi.inflate(R.layout.row, null);
            mHolder=new ViewHolder();
            mHolder.mImage=(ImageView)v.findViewById(R.id.img);
            mHolder.mName=(TextView)v.findViewById(R.id.name);
            mHolder.mPh=(TextView)v.findViewById(R.id.num);
            mHolder.mlayoutbg=(RelativeLayout)v.findViewById(R.id.layoutbg);
            v.setTag(mHolder);
        }
    else{
        mHolder=(ViewHolder)v.getTag();
    }
    imgLoader.DisplayImage(items.get(position).getImage(), loader, mHolder.mImage);
      //mHolder.mImage.setBackgroundResource(items.get(position).getImage());
    mHolder.mName.setText(items.get(position).getName());
    mHolder.mPh.setText(items.get(position).getPh());
    mHolder.mlayoutbg.setBackgroundColor(Color.GREEN);
    //      if(position%3==1){
    //          mHolder.mlayoutbg.setBackgroundColor(Color.GRAY);
    //      }else if(position%3==2){
    //          mHolder.mlayoutbg.setBackgroundColor(Color.WHITE);
    //      }else{
    //          mHolder.mlayoutbg.setBackgroundColor(Color.YELLOW);
    //      }
        return v;
}

public class ViewHolder {
    public  ImageView mImage;
    public TextView mName;
    public TextView mPh;
    public RelativeLayout mlayoutbg;

}

}