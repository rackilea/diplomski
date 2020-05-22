public class MyViewPager extends ViewPager {

    public MyViewPager (Context context) {
        super(context);
    }

    public MyViewPager (Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected boolean canScroll(View v, boolean checkV, int dx, int x, int y) {
        // Not satisfied with this method of checking...
        // working on a more robust solution
        if(v.getClass().getName().equals("maps.j.b")) {
            return true;
        }
        return super.canScroll(v, checkV, dx, x, y);
    }

}