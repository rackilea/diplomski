@Override
public Object instantiateItem(ViewGroup container, int position) {

    inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    View itemView = inflater.inflate(R.layout.viewpager_item, container, false);

    imageView= (ImageView) itemView.findViewById(R.id.image);
    tv_date= (TextView) itemView.findViewById(R.id.tv_date);
    tv_content= (TextView) itemView.findViewById(R.id.tv_content);

    Model item = (Model) arrayList.get(position);

    // Capture position and set to the ImageView
    imageView.setImageResource(item.getFlag());

    // Capture position and set to the TextViews
    tv_date.setText(item.getDate());
    tv_content.setText(item.getContent());

    ((ViewPager) container).addView(itemView);

    return itemView;
}