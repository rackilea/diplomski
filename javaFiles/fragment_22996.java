public class MyBottomSheetBehavior<V extends View> extends BottomSheetBehaviorAccessors<V> {

    // The bottom sheet that interests us.
    private View mBottomSheet;

    // Offset when sheet is expanded.
    private int mMinOffset;

    // Offset when sheet is collapsed.
    private int mMaxOffset;

    // This is the  bottom of the bottom sheet's parent.
    private int mParentBottom;

    // True if the bottom sheet is being moved through nested scrolls from NestedScrollView.
    private boolean mSheetCaptured = false;

    // True if the bottom sheet is touched directly and being dragged.
    private boolean mIsheetTouched = false;

    // Set to true on ACTION_DOWN on the NestedScrollView
    private boolean mScrollStarted = false;

    @SuppressWarnings("unused")
    public MyBottomSheetBehavior() {
    }

    @SuppressWarnings("unused")
    public MyBottomSheetBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onInterceptTouchEvent(CoordinatorLayout parent, V child, MotionEvent ev) {
        if (ev.getActionMasked() == MotionEvent.ACTION_DOWN) {
            mSheetCaptured = false;
            mIsheetTouched = parent.isPointInChildBounds(child, (int) ev.getX(), (int) ev.getY());
            mScrollStarted = !mIsheetTouched;
        }
        return super.onInterceptTouchEvent(parent, child, ev);
    }

    @Override
    public boolean onLayoutChild(CoordinatorLayout parent, V child, int layoutDirection) {
        mMinOffset = Math.max(0, parent.getHeight() - child.getHeight());
        mMaxOffset = Math.max(parent.getHeight() - getPeekHeight(), mMinOffset);
        mBottomSheet = child;
        mParentBottom = parent.getBottom();
        return super.onLayoutChild(parent, child, layoutDirection);
    }

    @Override
    public void onNestedPreScroll(@NonNull CoordinatorLayout coordinatorLayout,
                                  @NonNull V child, @NonNull View target, int dx, int dy,
                                  @NonNull int[] consumed, int type) {
        if (dy >= 0 || !mSheetCaptured || type != ViewCompat.TYPE_TOUCH
            || !(target instanceof NestedScrollView)) {
            super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed, type);
            return;
        }
        // Pointer moving downward (dy < 0: scrolling toward top of data)
        if (child.getTop() - dy <= mMaxOffset) {
            // Dragging...
            ViewCompat.offsetTopAndBottom(child, -dy);
            setStateInternalAccessor(STATE_DRAGGING);
            consumed[1] = dy;
        } else if (isHideable()) {
            // Hide...
            ViewCompat.offsetTopAndBottom(child, Math.min(-dy, mParentBottom - child.getTop()));
            consumed[1] = dy;
        } else if (mMaxOffset - child.getTop() > 0) {
            // Collapsed...
            ViewCompat.offsetTopAndBottom(child, mMaxOffset - child.getTop());
            consumed[1] = dy;
        }
        if (consumed[1] != 0) {
            dispatchOnSlideAccessor(child.getTop());
        }
    }

    @Override
    public void onNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V child,
                               @NonNull View target, int dxConsumed, int dyConsumed,
                               int dxUnconsumed, int dyUnconsumed, int type) {
        if (dyUnconsumed <= 0 || !(target instanceof NestedScrollView)
            || type != ViewCompat.TYPE_TOUCH || getState() == STATE_HIDDEN) {
            mSheetCaptured = false;
        } else if (!mSheetCaptured) {
            // Capture the bottom sheet only if it is at its collapsed height.
            mSheetCaptured = isSheetCollapsed();
        }
        if (!mSheetCaptured) {
            super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed,
                                 dxUnconsumed, dyUnconsumed, type);
            return;
        }

        /*
            If the pointer is moving upward (dyUnconsumed > 0) and the scroll view isn't
            consuming scroll (dyConsumed == 0) then the scroll view  must be at the end
            of its scroll.
        */
        if (child.getTop() - dyUnconsumed < mMinOffset) {
            // Expanded...
            ViewCompat.offsetTopAndBottom(child, mMinOffset - child.getTop());
        } else {
            // Dragging...
            ViewCompat.offsetTopAndBottom(child, -dyUnconsumed);
            setStateInternalAccessor(STATE_DRAGGING);
        }
        dispatchOnSlideAccessor(child.getTop());
    }

    @Override
    public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, V child, View target) {
        if (mScrollStarted) {
            // Ignore initial call to this method before anything has happened.
            mScrollStarted = false;
        } else if (!mIsheetTouched) {
            snapBottomSheet();
        }
        super.onStopNestedScroll(coordinatorLayout, child, target);
    }

    private void snapBottomSheet() {
        if ((mMaxOffset - mBottomSheet.getTop()) > (mMaxOffset - mMinOffset) / 2) {
            setState(BottomSheetBehavior.STATE_EXPANDED);
        } else if (shouldHideAccessor(mBottomSheet, 0)) {
            setState(BottomSheetBehavior.STATE_HIDDEN);
        } else {
            setState(BottomSheetBehavior.STATE_COLLAPSED);
        }
    }

    private boolean isSheetCollapsed() {
        return mBottomSheet.getTop() == mMaxOffset;
    }

    @SuppressWarnings("unused")
    private static final String TAG = "MyBottomSheetBehavior";
}