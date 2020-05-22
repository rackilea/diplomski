public boolean onPreDraw() {
    vhItem.txtB.getViewTreeObserver().removeOnPreDrawListener(this);
    vhItem.txtB.setVisibility(View.GONE);

    final int widthSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
    final int heightSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
    vhItem.txtB.measure(widthSpec, heightSpec);

    vhItem.textBHeight = vhItem.txtB.getMeasuredHeight();
    return true;
}