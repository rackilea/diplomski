public class CustomListAdapter extends ArrayAdapter<String>
 {
    Context context;
    int[] images;
    String[] titleArray;
    String[] descriptionArray;
    public CustomListAdapter(Context c, String[] title, int imgs[],String[] desc) {
        super(c, R.layout.activity_show,R.id.textView1,title);
        this.context = c;
        this.images = imgs;
        this.titleArray = title;
        this.descriptionArray = desc;
        // TODO Auto-generated constructor stub
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        ViewHolder viewHolder;

        if(convertView == null)
        {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.activity_show, parent,false);

            viewHolder.title = (TextView)convertView.findViewById(R.id.textView1);
            viewHolder.description = (TextView)convertView.findViewById(R.id.textView2);
            viewHolder.image = (ImageView) convertView.findViewById(R.id.image);
            convertView.setTag(viewHolder);
        }
        else
        {
            viewHolder = (ViewHolder) convertView.getTag();

            if(titleArray[position] != null)
            {
                viewHolder.image = (ImageView) convertView.findViewById(R.id.image);
                viewHolder.title= (TextView) convertView.findViewById(R.id.textView1);
                viewHolder.description = (TextView) convertView.findViewById(R.id.textView2);
                viewHolder.image.setImageResource(images[position]);
                viewHolder.title.setText(titleArray[position]);
                viewHolder.description.setText(descriptionArray[position]);
            }
        }
        return convertView;
    }

    private class ViewHolder
    {
        TextView title,description;
        ImageView image;
    }