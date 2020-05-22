package ca.test;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;

public class TestViewPager extends ViewPager {

    public TestViewPager(Context context) {
        super(context);
    }

    public TestViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected int getChildDrawingOrder(int childCount, int i) {
        return i;
    }

}