final Button button = new Button(this);
params = new RelativeLayout.LayoutParams(50, 50);
layout.addView(button, params);
button.post(new Runnable()
{
@Override
public void run()
{
    button.buildDrawingCache();
    Bitmap viewCopy = button.getDrawingCache();

    boolean stillBorder = true;
    PaddingLeft = 0;
    PaddingTop = 0;
    while (stillBorder)
    {
        int color = viewCopy.getPixel(PaddingLeft, button.getHeight() / 2);
        if (color != Color.TRANSPARENT)
            stillBorder = false;
        else
            PaddingLeft++;
    }              
    stillBorder = true;
    while (stillBorder)
    {
        int color = viewCopy.getPixel(button.getWidth() / 2, PaddingTop);
        if (color != Color.TRANSPARENT)
            stillBorder = false;
        else
            PaddingTop++;
    }
}
});