public class SomeLayout extends ViewGroup {

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        getChildAt(0).measure(MeasureSpec.makeMeasureSpec(300, MeasureSpec.EXACTLY), heightMeasureSpec);
        getChildAt(1).measure(widthMeasureSpec, heightMeasureSpec);

        setMeasuredDimension(getChildAt(0).getMeasuredWidth() + getChildAt(1).getMeasuredWidth(),
                Math.max(getChildAt(0).getMeasuredHeight(), getChildAt(1).getMeasuredHeight()));
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        getChildAt(0).layout(l, t, l + getChildAt(0).getMeasuredWidth(), b);
        getChildAt(1).layout(l + getChildAt(0).getMeasuredWidth(), t,
                l + getChildAt(0).getMeasuredWidth() + getChildAt(1).getMeasuredWidth(), b);
    }
}