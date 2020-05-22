public Object instantiateItem(View collection, int position) {
LayoutInflater inflater = (LayoutInflater)collection.getContext().getSystemService
             (Context.LAYOUT_INFLATER_SERVICE);
    View layout = inflater.inflate(R.layout.custom_pager, null);

                    ImageView im=(ImageView) layout.findViewById(R.id.gallery_imageView);
                    im.setBackgroundColor(Color.RED);
                    TextView dsc=(TextView) layout.findViewById(R.id.gallery_imageView_dsc);
                    ((ViewPager) collection).addView(layout, 0);
                    return layout;   }