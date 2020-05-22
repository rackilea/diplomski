private class MyPagerAdapter extends PagerAdapter {
        int[] internalPicts = {R.drawable.dashboard, R.drawable.icon, R.drawable.mockup};

        public MyPagerAdapter() {
            super();
        }

        @Override
        public int getCount() {
            return internalPicts.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup collection, int position) {

            // Inflating layout
            LayoutInflater inflater = (LayoutInflater) collection.getContext()
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View view = inflater.inflate(R.layout.record_images_pager, null);

            ImageView image = (ImageView) view.findViewById(R.id.image);

            image.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), internalPicts[position]));

            collection.addView(view, 0);
            return view;

        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }