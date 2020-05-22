package android.support.design.widget; // important!

// A "friend" class to provide access to some package-private methods in `BottomSheetBehavior`.
public class BottomSheetBehaviorAccessors<V extends View> extends BottomSheetBehavior<V> {

    @SuppressWarnings("unused")
    protected BottomSheetBehaviorAccessors() {
    }

    @SuppressWarnings("unused")
    public BottomSheetBehaviorAccessors(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    protected void setStateInternalAccessor(int state) {
        super.setStateInternal(state);
    }

    protected void dispatchOnSlideAccessor(int top) {
        super.dispatchOnSlide(top);
    }

    protected boolean shouldHideAccessor(View child, float yvel) {
        return mHideable && super.shouldHide(child, yvel);
    }

    @SuppressWarnings("unused")
    private static final String TAG = "BehaviorAccessor";
}