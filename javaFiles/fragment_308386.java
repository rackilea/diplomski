private ArrayList<Things> things;
private Context context;
private TextView yearTxtView;
private TextView weekTxtView;
private TextView extraTxtView;


public YourAdapter(Context context, ArrayList<Things> things) {
    this.things = things;
    this.context = context;
}

@Override
public int getCount() {
    return this.things.size();
}

@Override
public Object getItem(int position) {
    return this.things.get(position);
}

@Override
public long getItemId(int position) {
    return position;
}

@Override
public View getView(int position, View convertView, ViewGroup parent) {
    convertView =     LayoutInflater.from(this.context).inflate(R.layout.ITEM_LAYOUT, parent, false);

    convertView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //do your code here
        }
    });

    return convertView;


}