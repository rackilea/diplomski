public class SecondArrayListAdapter extends BaseAdapter {

ArrayList<ListCustomObjects> datas;
Context context;


public SecondArrayListAdapter(Context context,ArrayList<ListCustomObjects> datas) {
this.context=context;
    this.datas=datas;
}

@Override
public int getCount() {
    return datas.size();
}

@Override
public Object getItem(int position) {
    return datas.get(position);
}

@Override
public long getItemId(int position) {
    return position;
}

@Override
public View getView(int position, View convertView, ViewGroup parent) {
    ViewHolder viewHolder;
    //where we check the convertview whethere it is creting first time or not
    if(convertView==null){
        convertView=((LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.sample_data_listview_item,null);
        viewHolder=new ViewHolder();

        viewHolder.image=(ImageView)convertView.findViewById(R.id.sample_listview_item_imageView);
        viewHolder.name=(TextView)convertView.findViewById(R.id.sample_listview_item_name);

        convertView.setTag(viewHolder);
    }
    //where we get the views from convertview instead of creating new one.It reduces memory consumption
    else{
        viewHolder=(ViewHolder)convertView.getTag();
    }
    //here we set the name
    viewHolder.name.setText(datas.get(position).getName());
    //here conversion takes place.
    byte[] imageAsBytes = android.util.Base64.decode(datas.get(position).getPath().getBytes(), android.util.Base64.DEFAULT);
    viewHolder.image.setImageBitmap(BitmapFactory.decodeByteArray(imageAsBytes, 0, imageAsBytes.length));
    return convertView;
}
//this is used to bind the view as single class
class ViewHolder{
    ImageView image;
    TextView name;
}
}