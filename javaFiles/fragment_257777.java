@Override
public boolean setVisible(boolean visible, boolean restart) {
    return drawable.setVisible(visible, restart);
}

@Override
public void setBounds(int left, int top, int right, int bottom) {
    drawable.setBounds(left, top, right, bottom);
}

@Override
public void setBounds(Rect bounds) {
    drawable.setBounds(bounds);
}

@Override
public int getIntrinsicHeight() {
    return drawable.getIntrinsicHeight();
}

@Override
public int getIntrinsicWidth() {
    return drawable.getIntrinsicWidth();
}