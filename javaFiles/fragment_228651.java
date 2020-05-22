@Override
public View getView(int position, View convertView, ViewGroup parent) {
    // TODO Auto-generated method stub
    Log.d("dupa", "!!!!getView");

    LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    View row = inflater.inflate(R.layout.row_layout,parent,false);
    TextView tv = (TextView) row.findViewById(R.id.movieTitle);         

    tv.setText(tabObj[position]);

    //Button buton1 = (Button) row.findViewById(R.id.buttonInfo);
    //Button button2 = (Button) row.findViewById(R.id.buttonReserve);

    return row;
}