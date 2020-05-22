@Override
public View getView(int position, View convertView, ViewGroup parent) {

    ViewHolder holder;

    if (convertView == null) {
        convertView = inflater.inflate(R.layout.cart_row, parent, false);
        holder = new ViewHolder();
        holder.decrement = (TextView) convertView.findViewById(R.id.decrement);
        holder.single = (TextView) convertView.findViewById(R.id.single);
        holder.increment = (TextView) convertView.findViewById(R.id.increment);
        holder.cancel = (TextView) convertView.findViewById(R.id.cancel);
        holder.vcmedname = (TextView) convertView.findViewById(R.id.vcmedname);
        holder.vcmedprice = (TextView) convertView.findViewById(R.id.vcmedprice);

        convertView.setTag(holder);
    }
    else {
        holder = (ViewHolder) convertView.getTag();
    }
        Typeface carttext = Typeface.createFromAsset(cartcontext.getAssets(), "fonts/fontawesome.ttf");
        holder.decrement.setTypeface(carttext);
        holder.increment.setTypeface(carttext);
        holder.cancel.setTypeface(carttext);

    MobiData newcart = cartlist.get(position);
    holder.vcmedname.setText(newcart.getVcmedname());
    holder.vcmedprice.setText(newcart.getVcmedprice());
    holder.single.setText(newcart.getVcqty());
    final String cartids = newcart.getVcmedid();

    holder.cancel.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            cartlist.remove(position);
            notifyDataSetChanged();
        }
    });
    return convertView;
}

static class ViewHolder {

  private TextView decrement;
  private TextView single;
  private TextView increment;
  private TextView vcmedname;
  private TextView vcmedprice;

 }