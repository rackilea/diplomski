public class CustomEditText extends EditText {
    int shadowColor = 0;

    public CustomEditText(Context context) {
        super(context);
    }

    public CustomEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void setShadowLayer(float radius, float dx, float dy, int color) {
        shadowColor = color;
        super.setShadowLayer(radius, dx, dy, color);
    }

    public int getShadowLayerColor() {
        return shadowColor;
    }
}