public class ListAdapter extends ArrayAdapter<String> {

private int resourceLayout;
private Context mContext;
ListInterFace interface;

public ListAdapter(Context context, int resource, List<String> 
   items,ListInterFace interface) {
    super(context, resource, items);
    this.resourceLayout = resource;
    this.mContext = context;
    this.interface=interface;
}

@Override
public View getView(int position, View convertView, ViewGroup parent) {

    View v = convertView;

    if (v == null) {
        LayoutInflater vi;
        vi = LayoutInflater.from(mContext);
        v = vi.inflate(resourceLayout, null);
    }

    String value= getItem(position);

    if (value!= null) {
        TextView tt1 = (TextView) v.findViewById(R.id.dummytext);
        Button cancel_click=v.findViewById(R.id.cancel_click);

        if (tt1 != null) {
            tt1.setText(value);
        }
       //remove item on button click
        cancel_click.setOnClickListener(new  View.OnClickListener(){
        @Override
        public void onClick(View view){
            interface.removeItem(position);
        }
    })
    }

    return v;
}