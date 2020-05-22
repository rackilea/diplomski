private boolean contentFits() {
    final int childCount = getChildCount();
    if (childCount == 0) return true;
    if (childCount != mItemCount) return false;

    return getChildAt(0).getTop() >= mListPadding.top &&
            getChildAt(childCount - 1).getBottom() <= getHeight() - mListPadding.bottom;
}