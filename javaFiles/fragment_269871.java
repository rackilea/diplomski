for (int i = 0; i < count; i++) {
    final View child = children[getChildDrawingOrder(count, i)];
    if ((child.mViewFlags & VISIBILITY_MASK) == VISIBLE || child.getAnimation() != null) {
        more |= drawChild(canvas, child, drawingTime);
    }
}