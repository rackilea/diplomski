// create a new TextView for each item referenced by the Adapter
    public View getView(final int position, View convertView, final ViewGroup parent) {
        View listView = convertView;

        if (listView == null) { // if it's not recycled, initialize some attributes
            // get layout from xml
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            listView = inflater.inflate(R.layout.browse_product_item, null);
        }


        final ListProductHolder holder;

        if (listView.getTag() != null) {
            holder = (listProductHolder) listView.getTag();
        } else {
            holder = new listProductHolder();
            listView.setTag(holder);

            holder.text= (TextView) listView.findViewById(R.id.quantity);