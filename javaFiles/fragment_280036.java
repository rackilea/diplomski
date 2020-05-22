public class CustomAdapter extends ArrayAdapter<Sample> {

public ArrayList<Sample> mlist;
public Context context;
public LayoutInflater inflater;

public CustomAdapter(Context context, int resource, ArrayList<Sample> mlist) {
    super(context, resource);
    this.mlist = mlist;
    this.context = context;
    inflater = (LayoutInflater) context
            .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
}

@Override
public int getPosition(Sample item) {
    return super.getPosition(item);
}

@Override
public Sample getItem(int position) {
    return mlist.get(position);
}

@Override
public int getCount() {
    return mlist.size();
}

@Override
public long getItemId(int position) {
    return super.getItemId(position);
}

@Override
public View getView(int position, View convertView, ViewGroup parent) {
    convertView = inflater.inflate(R.layout.listitem, null);//Replace your layout....
    TextView text1 = (TextView) convertView.findViewById(R.id.item1);
    TextView text2 = (TextView) convertView.findViewById(R.id.item2);
    text1.setText(mlist.get(position).getListitem1());
    text2.setText(mlist.get(position).getListitem2());
    text2.setOnClickListener(new OnClickListener() {
        @Override
        public void onClick(View v) {
            // you just put your Logic here And use this custom adapter to
            // load your Data By using this particular custom adapter to
            // your listview
                            //Change your imageview here

        }
    });
    return convertView;
}

 }