public Object instantiateItem(View collection, int position) {
LayoutInflater inflater = (LayoutInflater)collection.getContext().getSystemService
             (Context.LAYOUT_INFLATER_SERVICE);
    View layout = inflater.inflate(R.layout.custom_pager, null);

    layout.findViewById(R.id.caption);

 ImageView view = new ImageView(activity);                      
    view.setPadding(5, 25, 5, 5);
    view.setScaleType(ScaleType.FIT_START);
    view.setBackgroundColor(Color.RED);
    ((ViewPager) collection).addView(view, 0);
    return view;   }