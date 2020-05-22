public class MyAdapter extends BaseAdapter {
private Activity activity;
private List<Bean> mList;
private static LayoutInflater inflater;

public MyAdapter(Activity act,List<Bean> list){
    activity=act;
    mList=list;
    inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
}

@Override
public int getCount() {
    return mList.size();
}

@Override
public Object getItem(int position) {
    return mList.get(position);
}

@Override
public long getItemId(int position) {
    return position;
}

@Override
public View getView(int position, View convertView, ViewGroup parent) {

    ViewHolder holder;
    //use converview recycle
    if(convertView==null){
        convertView = inflater.inflate(R.layout.content_orders, null);
        holder=new ViewHolder();
        holder.textView= (TextView) convertView.findViewById(R.id.textView2);
        holder.imageView= (ImageView) convertView.findViewById(R.id.imageView2);
        convertView.setTag(holder);
    }else{
        holder = (ViewHolder) convertView.getTag();
    }

    //set text and url
    holder.textView.setText(mList.get(position).getText());
    Picasso.with(activity).load(mList.get(position).getUrl()).into(holder.imageView);

    return convertView;
}

class ViewHolder{
    TextView textView;
    ImageView imageView;

}
}