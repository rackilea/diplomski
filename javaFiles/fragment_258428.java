import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;

import androidx.coordinatorlayout.widget.CoordinatorLayout;

/**
 * Modified by Surya Jeet Singh
 */

public class GridLayoutMyAuto extends CoordinatorLayout {


    private int row = 4;
    private int column = 4;
    private double childWidth;
    private double childHeight;
    private int child_layout;
    private boolean width_acc_height = false, height_acc_width = false;
    private View[][] grid;

    public GridLayoutMyAuto(Context context) {
        super(context);
    }

    public GridLayoutMyAuto(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public GridLayoutMyAuto(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }


    private void init(Context context, AttributeSet attrs) {
        TypedArray typedArray = context
                .obtainStyledAttributes(attrs, R.styleable.GridLayoutMyAuto);

        row = typedArray.getInteger(R.styleable.GridLayoutMyAuto_row, 5);
        column = typedArray.getInteger(R.styleable.GridLayoutMyAuto_column, 5);
        child_layout = typedArray.getResourceId(R.styleable.GridLayoutMyAuto_child_layout,/*R.child_layout.include_item_2048*/-1);
        width_acc_height = typedArray.getBoolean(R.styleable.GridLayoutMyAuto_width_acc_height, false);
        height_acc_width = typedArray.getBoolean(R.styleable.GridLayoutMyAuto_height_acc_width, false);

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                inflate(context, child_layout, this);
            }
        }
        typedArray.recycle();

    }

    public void resetLayout() {
        requestLayout();
    }


    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public View[][] getGrid() {
        return grid;
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int childCount = getChildCount();
        int newHeight = row * (widthMeasureSpec / column);

        if (width_acc_height == true) {
            widthMeasureSpec = heightMeasureSpec;
        } else if (height_acc_width == true) {
            heightMeasureSpec = widthMeasureSpec;
        }
        for (int i = 0; i < childCount; i++) {
            View child = getChildAt(i);
            int padding = child.getPaddingLeft();
            if (child.getVisibility() != View.GONE) {
                measureChild(child, widthMeasureSpec / column - 2 * padding, heightMeasureSpec / row - 2 * padding);
            }
        }

        setMeasuredDimension(widthMeasureSpec, heightMeasureSpec);

    }

    @Override
    protected void onLayout(boolean b, int left, int top, int right, int bottom) {

        grid = new View[row][column];

        childWidth = (right - left) / (column * 1.0);
        childHeight = (bottom - top) / (row * 1.0);

        int x;
        int y = top;
        int count = 0;
        for (int i = 0; i < row; i++) {
            x = left;
            for (int j = 0; j < column; j++) {
                View child = getChildAt(count++);
                int padding = child.getPaddingLeft();
//                padding=18;
                child.layout(x + padding, y + padding, (int) (x + childWidth) - padding, (int) (y + childHeight) - padding);
                grid[i][j] = child;
                x += childWidth;
            }
            y += childHeight;

        }
    }


}