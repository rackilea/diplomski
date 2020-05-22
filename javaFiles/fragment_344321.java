@Override
public View getView(int position, View convertView, ViewGroup parent) {

    LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    View rowView = inflater.inflate(R.layout.rowlayout, parent, false);

    TextView textView = (TextView) rowView.findViewById(R.id.label);

    ...