DisplayMetrics dm = new DisplayMetrics();
    this.getWindowManager().getDefaultDisplay().getMetrics(dm);
    factor_y = (dm.ydpi * dm.heightPixels) / (160 * 480);
    factor_x = (dm.xdpi * dm.widthPixels) / (160 * 320);

LinearLayout layout = (LinearLayout) findViewById(R.id.mainlayout);
for (int i = 0; i < layout.getChildCount(); i++)
{
    View v = layout.getChildAt(i);
    int height = v.getLayoutParams().height;
    if (height > 0)
    {
        v.getLayoutParams().height = (int) ((float) height * factor_y);
    }
    int width = v.getLayoutParams().width;
    if (width > 0)
    {
        v.getLayoutParams().width = (int) ((float) width * factor_x);
    }
}