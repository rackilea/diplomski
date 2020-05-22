private boolean contentFits() {
    final int childCount = getChildCount();
    if (childCount != mItemCount) {
        return false;
    }

    return getChildAt(0).getTop() >= 0 && getChildAt(childCount - 1).getBottom() <= mBottom;
}