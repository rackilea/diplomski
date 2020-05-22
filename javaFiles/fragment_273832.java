package com.example.clinic; 

public class CustomListViewAdapter extends BaseAdapter
{   
private Context context; 
Button btchange,btdelete;
LayoutInflater inflater;
List<ListViewItem> items;

public CustomListViewAdapter(Activity context, List<ListViewItem> items) {  
    super();
    this.context = context;  
    this.items = items;
    this.inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
}

@Override  
public int getCount() {  
    // TODO Auto-generated method stub  
    return items.size();  
}  
 @Override  
public Object getItem(int position) {  
    // TODO Auto-generated method stub  
    return null;  
}  

@Override  
public long getItemId(int position) {  
    // TODO Auto-generated method stub  
    return 0;  
}

@Override  
public View getView(final int position, View convertView, ViewGroup parent) {  
    // TODO Auto-generated method stub  

View vi=convertView;

    if(convertView==null)
        vi = inflater.inflate(R.layout.item_row, null);

    //add
    ListViewItem item = items.get(position);

    TextView txtsection = (TextView)vi.findViewById(R.id.section);
    TextView txtdoctor = (TextView)vi.findViewById(R.id.doctor);
    TextView txtdate = (TextView)vi.findViewById(R.id.date);
    TextView txttime = (TextView)vi.findViewById(R.id.time);  
    btchange = (Button)vi.findViewById(R.id.change);

    btchange.setOnClickListener(new OnClickListener() {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            Intent i = new Intent(context, Available.class);

            //updated
            context.startActivity(i);

        }
    });

    btdelete = (Button)vi.findViewById(R.id.delete);

    txtsection.setText(item.section);
    txtdoctor.setText(item.doctor);
    txtdate.setText(item.date);
    txttime.setText(item.time);

    return vi;  
}