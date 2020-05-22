public class ImageAdapter extends BaseAdapter
{
    private Context context;
    private ArrayList<GridViewItem> gridViewItems;  

    public ImageAdapter(Context context, ArrayList<GridViewItem> gridViewItems)
    {
        this.context = context;
        this.gridViewItems = gridViewItems;
    }

    @Override
    public int getCount() 
    {
        return gridViewItems.size();
    }

    @Override
    public Object getItem(int position) 
    {       
        return gridViewItems.get(position);
    }

    @Override
    public long getItemId(int position) 
    {
       return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) 
    {
        if (convertView == null) 
        {
             LayoutInflater mInflater = (LayoutInflater)
                  context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
             convertView = mInflater.inflate(R.layout.image_item, null);
        }

        ImageView imgIcon = (ImageView) convertView.findViewById(R.id.icon_item);
        imgIcon.setImageResource(gridViewItems.get(position).getIcon());

        return convertView;
    }
}