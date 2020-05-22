MenuAdapter(Context context, List<MyMenuItem> menuItems) {
    this.mLayoutInflater = LayoutInflater.from(content);
    this.mPicasso = Picasso.with(context);
}
..
@Override
public View getView(int position, View convertView, ViewGroup parent) {
    if (convertView == null) {
        convertView = mInflater.inflate(R.layout.menu_item, null);
    ...
    mPicasso
            .load(row_pos.getItem_image_url())
            .into(holder.ivMenu);