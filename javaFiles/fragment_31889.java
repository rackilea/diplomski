MyAdapter.java 
public class MyAdapter extends ArrayAdapter<MyData>{

    Context context; 
    int layoutResourceId;    
    MyData data[] = null;

    public MyAdapter(Context context, int layoutResourceId, Mydata[] data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        WeatherHolder holder = null;

        if(row == null)
        {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new WeatherHolder();
            holder.imgIcon = (TextView)row.findViewById(R.id.txtTitle);
            holder.txtTitle = (TextView)row.findViewById(R.id.txtTitle);

            row.setTag(holder);
        }
        else
        {
            holder = (WeatherHolder)row.getTag();
        }

        MyData data = data[position];
        holder.txtTitle1.setText(data.title);
        holder.txtTitle2.setText(data.icon);

        return row;
    }

    static class WeatherHolder
    {
        TextView txtTitle1;
        TextView txtTitle2;
    }
}