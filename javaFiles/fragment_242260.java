@Override
    public View getView(final int position, View convertView, final ViewGroup parent) {

        ViewHolder vh;
        if (convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.row_grid_item, parent, false);

            vh = new ViewHolder();
            vh.imgView = (DynamicHeightImageView) convertView.findViewById(R.id.imgView);
            vh.price = (TextView) convertView.findViewById(R.id.price);
            vh.name = (TextView) convertView.findViewById(R.id.name);

            convertView.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }

        HashMap<String,String> map = getItem(position);
        vh.price.setText(map.get(CategoryCarActivity.TAG_PRICE));
        vh.name.setText(map.get(CategoryCarActivity.TAG_NAME));

        double positionHeight = getPositionRatio(position);

        vh.imgView.setHeightRatio(positionHeight);

        // ImageLoader.getInstance().displayImage(getItem(position), vh.imgView);
        return convertView;
    }