@Override
public View getView(int position, View convertView, ViewGroup parent) {

    ViewHolder holder;
    LayoutInflater inflater =  activity.getLayoutInflater();

    if (convertView == null) {
        convertView = inflater.inflate(R.layout.rows, null);
        holder = new ViewHolder();
        holder.txtFirst = (TextView) convertView.findViewById(R.id.column1);
        holder.txtSecond = (TextView) convertView.findViewById(R.id.column2);
        convertView.setTag(holder);
        // Set the listener
        holder.txtSecond.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_CALL);
                String phone_no=tv.getText().toString().trim();
                intent.setData(Uri.parse("tel:"+phone_no));
                startActivity(intent);

            }
        });
    } else {
        holder = (ViewHolder) convertView.getTag();
    }

    HashMap<String, String> map = list.get(position);
    holder.txtFirst.setText(map.get(column1));
    holder.txtSecond.setText(map.get(column2));


    return convertView;
}