public class RadioAdapter extends BaseAdapter
{
    ArrayList<RadioStation> myList = new ArrayList<RadioStation>();
    LayoutInflater inflater;
    Context context;
    ListView mListview;

    public RadioAdapter(Context context, ArrayList<RadioStation> myList, ListView list) {
        this.myList = myList;
        this.context = context;
        mListView = list;
        inflater = LayoutInflater.from(this.context);
    }

    @Override
    public int getCount() {
        return myList.size();
    }

    @Override
    public RadioStation getItem(int position) {
        return myList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        MyViewHolder mViewHolder;

        if(convertView == null) {
            convertView = inflater.inflate(R.layout.activity_menu_row, null);
            mViewHolder = new MyViewHolder();
            convertView.setTag(mViewHolder);
        } else {
            mViewHolder = (MyViewHolder) convertView.getTag();
        }

        mViewHolder.tvTitle = detail(convertView, R.id.label, myList.get(position).getTitle());
        mViewHolder.tvDesc  = detail(convertView, R.id.label2,  myList.get(position).getDescription());
        mViewHolder.ivIcon  = detail(convertView, R.id.icon,  myList.get(position).getImgResId());
        convertView.findViewById(R.id.favButton).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                myList.get(position).isFavorite=! myList.get(position).isFavorite;
                //reorder mlist
                notifyDataSetChanged();
                //mListView. smoothscroll here
            }
        });

        ((ImageView) convertView.findViewById(R.id.favButton)).setImageResource(myList.get(position).isFavorite?R.drawable.favoriteOn:R.drawable.favoriteOff);
        return convertView;
    }

    private TextView detail(View v, int resId, String text) {
        TextView tv = (TextView) v.findViewById(resId);
        tv.setText(text);
        return tv;
    }

    private ImageView detail(View v, int resId, int icon) {
        ImageView iv = (ImageView) v.findViewById(resId);
        iv.setImageResource(icon); //
        return iv;
    }

    private class MyViewHolder {
        TextView tvTitle, tvDesc;
        ImageView ivIcon;
    }
}