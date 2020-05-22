private View createTabView(final Context context, final int textStringId, final int imageResId) {
        View view = LayoutInflater.from(context).inflate(R.layout.tabs_bg, null);
        ImageView iv = (ImageView) view.findViewById(R.id.tabsIcon);
        iv.setImageResource(imageResId);
        TextView tv = (TextView) view.findViewById(R.id.tabsText);
        tv.setText(textStringId);
        return view;
    }