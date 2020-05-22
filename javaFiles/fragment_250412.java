public class MyImageView extends CropImageView
{
    public int mVideoWidth  = 0;
    public int mVideoHeight = 0;

    private boolean isFixed = false;

    public MyImageView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
    }

    public MyImageView(Context context, AttributeSet attrs, int defStyle)
    {
        super(context, attrs, defStyle);
    }

    public MyImageView(Context context)
    {
        super(context);
    }

    public void setImageSize(int width, int height)
    {
        mVideoWidth = width;
        mVideoHeight = height;
        invalidate();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
    {
        // Log.i("@@@", "onMeasure");
        int width = getDefaultSize(mVideoWidth, widthMeasureSpec);
        int height = getDefaultSize(mVideoHeight, heightMeasureSpec);
        if (mVideoWidth > 0 && mVideoHeight > 0)
        {
            if (mVideoWidth * height > width * mVideoHeight)
            {
                height = width * mVideoHeight / mVideoWidth;
            } else if (mVideoWidth * height < width * mVideoHeight)
            {
                width = height * mVideoWidth / mVideoHeight;
            } else
            {
                // Log.i("@@@", "aspect ratio is correct: " +
                // width+"/"+height+"="+
                // mVideoWidth+"/"+mVideoHeight);
            }
        }
        setMeasuredDimension(width, height);
    }
}