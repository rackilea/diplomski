LayoutInflater layoutInflater = getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.row_item, null);

        TextView Title = (TextView) view.findViewById(R.id.text_view_title);
        TextView info = (TextView) view.findViewById(R.id.text_view_info);
        ImageView img = (ImageView) view.findViewById(R.id.row_img);