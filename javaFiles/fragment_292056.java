public class MyAspectButton extends Button
{
    private float m_aspect = -1.f;

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
    {
        super.onMeasure(MyMeasuringClass.MeasureWidth(this, widthMeasureSpec), MyMeasuringClass.MeasureHeight(this, heightMeasureSpec));
    }
}