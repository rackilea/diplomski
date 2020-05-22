@Override
public void destroyItem(View view, int arg1, Object object) {
         ((ViewPager) view).removeView((View)object);
}
@Override
public int getCount() {
          return views.size();
}
@Override
public Object instantiateItem(View view, int position) {
           View view = views.get(position);
           ((ViewPager) view).addView(view);
           return view;
}
@Override
public boolean isViewFromObject(View view, Object object) {
           return view == object;
}