@Override
public void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
{
    // Call the super class.
    super.onMeasure(widthMeasureSpec, heightMeasureSpec);

    // Set the dimensions of this view.
    this.setMeasuredDimension((int) width, (int) width);
}