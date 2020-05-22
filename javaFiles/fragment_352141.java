public Activity activity;
public ArrayList<String> text;

public listAdapter(Activity activity){

    this.activity = activity;
}

public void setText(ArrayList<String> text){
    this.text = text;
}

public int getCount() {
    return 5;
}

public Object getItem(int position) {

    return null;
}

public long getItemId(int position) {
    // TODO Auto-generated method stub
    return 0;
}

public View getView(int position, View convertView, ViewGroup parent) {
    LayoutInflater inflater = activity.getLayoutInflater();
    LinearLayout rowView = (LinearLayout) inflater.inflate(R.layout.row_layout, null);
    TextView textView = (TextView) rowView.findViewById(R.id.row_text);
    textView.setText(text[position]);
    return rowView;
}