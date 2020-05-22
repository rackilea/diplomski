@Override
protected void onLayout(boolean changed, int l, int t, int r, int b) {
    super.onLayout(changed, l, t, r, b);
    listParams.setMargins(getLeft(),getTop()+getHeight(),getRight(),getBottom());
    list.setLayoutParams(listParams);
    list.bringToFront();
}