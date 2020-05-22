@Override
public boolean canScrollHorizontally(int direction)
{
    final int offset = computeHorizontalScrollOffset();
    final int range = computeHorizontalScrollRange() - computeHorizontalScrollExtent();
    if(range == 0){
        return false;
    }
    return (direction < 0) ? (offset > 0) : (offset < range - 1);
}

protected void onScrollChanged(int l, int t, int oldl, int oldt)
{
    left .setVisibility(canScrollHorizontally(-1) ? View.VISIBLE : View.GONE);
    right.setVisibility(canScrollHorizontally( 1) ? View.VISIBLE : View.GONE);
}