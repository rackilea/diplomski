@Override
public View getView(int position, View convertView, ViewGroup parent) {

...

    add_cart = (ImageView) convertView.findViewById(R.id.icon);
    add_cart.setTag(convertView);

    add_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
    TextView prezzo = (TextView) ((View)v.getTag()).findViewById(R.id.editText2);
               String prezzoStr = prezzo.getText().toString();
            }
        });