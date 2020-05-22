@Override
public boolean onPreDraw() {
    txtSubtitle.getViewTreeObserver().removeOnPreDrawListener(this);
                                txtSubtitle.setVisibility(View.GONE);
    final int widthSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
    final int heightSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
                                txtSubtitle.measure(widthSpec, heightSpec);
    viewHolder.height = txtSubtitle.getMeasuredHeight();
    return true;
}