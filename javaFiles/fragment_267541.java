@Override
public Object instantiateItem(View collection, int position) {
    View v = layoutInflater.inflate(...);
    ...
    ((ViewPager) collection).addView(v,0);
    return tv;
}

@Override
public void destroyItem(View collection, int position, Object view) {
    ((ViewPager) collection).removeView((TextView) view);
}