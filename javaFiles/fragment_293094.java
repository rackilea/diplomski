public class NoSwipePager extends ViewPager {
  public NoSwipePager(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  @Override
  protected boolean canScroll(View v, boolean checkV, int dx, int x,
                              int y) {
    if (v instanceof RecyclerView) {
      return(true);
    }

    return(super.canScroll(v, checkV, dx, x, y));
  }
}