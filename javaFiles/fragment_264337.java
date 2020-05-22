TypedArray ta = getResources().obtainTypedArray(R.array.array_category_icons);
Drawable[] icons = new Drawable[ta.length()];
for (int i = 0; i < ta.length(); i++) {
    int id = ta.getResourceId(i, 0);
    if (id != 0) {
        icons[i] = ContextCompat.getDrawable(this, id);
    }
}
ta.recycle();