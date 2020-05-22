public class MyPagerAdapter extends PagerAdapter {

        Activity activity;
        int txtarray[];

        public MyPagerAdapter(Activity act, int[] imgArra) {
            txtarray = imgArra;
            activity = act;
        }

        public int getCount() {
            return txtarray.length;
        }

        public Object instantiateItem(View collection, int position) {
            TextView view = new TextView(activity);
            view.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,
                    LayoutParams.FILL_PARENT));
            view.setText(txtarray[position]);
            ((ViewPager) collection).addView(view, 0);
            return view;
        }

        @Override
        public void destroyItem(View arg0, int arg1, Object arg2) {
            ((ViewPager) arg0).removeView((View) arg2);
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0 == ((View) arg1);
        }

        @Override
        public Parcelable saveState() {
            return null;
        }
    }