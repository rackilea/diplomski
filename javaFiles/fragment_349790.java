@Override
public View getView(final int position, View convertView, ViewGroup parent) {
    final PackageItem item = getItem(position);
    ViewHolder holder;
    if (convertView == null) {
        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = li.inflate(R.layout.package_row, parent, false);
                         ^^^^^^^^^^^^^^^^^^^^^^^^^^^^
        holder = new ViewHolder();
        holder.ivImage = (ImageView) convertView.findViewById(R.id.example_row_iv_image);
        ...
    } else {
        holder = (ViewHolder) convertView.getTag();
    }
    ...