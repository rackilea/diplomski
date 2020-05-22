@Override
    public View getView(int position, View conertView, ViewGroup parent){
        if (convertView == null) {
        LayoutInflater inflater = (LayoutInflater)
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
          convertView = inflater.inflate(R.layout.order_object_layout, parent, false);
        }
        /** Gather items from the view */
        TextView p_name = (TextView) convertView.findViewById(R.id.product_name);
        TextView p_value = (TextView) convertView.findViewById(R.id.product_value);
        TextView p_quantity = (TextView) convertView.findViewById(R.id.product_quantity);
        /** Asign data to the text views */
        OrderItem item = (OrderItem) object.get(position);
        p_name.setText(item.getName());
        return convertView;
    }