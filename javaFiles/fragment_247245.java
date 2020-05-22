private int width;
private int height;
private int paddingLeft;
private int paddingRight;
private int paddingTop;
private int paddingBottom;
private int centerX;
private int centerY;

@Override
public void onSizeChanged(int w, int h, int oldw, int oldh) {
    super.onSizeChanged(w, h, oldw, oldh);
    width = w;
    height = h;
    paddingLeft = getPaddingLeft();
    paddingRight = getPaddingRight();
    paddingTop = getPaddingTop();
    paddingBottom = getPaddingBottom();
    int usableWidth = width - (paddingLeft + paddingRight);
    int usableHeight = height - (paddingTop + paddingBottom);
    centerX = paddingLeft + (usableWidth / 2);
    centerY = paddingTop + (usableHeight / 2);
}