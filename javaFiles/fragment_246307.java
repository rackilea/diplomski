public View getView(int position, View convertView, ViewGroup parent) {
    ViewHolder holder;
    if (convertView == null) {
        holder = new ViewHolder();
        convertView = mInflater.inflate(
                R.layout.galleryitem, null);

        int yourExpectedHeight = 100;
        convertView.setLayoutParams(new GridView.LayoutParams(GridView.LayoutParams.MATCH_PARENT,
            yourExpectedHeight));

        holder.imageview = (ImageView) convertView.findViewById(R.id.thumbImage);

        convertView.setTag(holder);
    }
    else {
        holder = (ViewHolder) convertView.getTag();
    }


    Bitmap myBitmap = BitmapFactory.decodeFile(f.get(position));
    holder.imageview.setImageBitmap(myBitmap);
    return convertView;
}