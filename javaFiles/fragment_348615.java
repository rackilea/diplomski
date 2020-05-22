public class DrawableItemSelectedBackgroundITopColor
{
    LayerDrawable layerdrawable;
    Drawable[] DrawableArray;

    ColorDrawable topColor;
    ColorDrawable bottomColor;

    public DrawableItemSelectedBackgroundITopColor(Context context, String Theme)
    {

        topColor = new ColorDrawable(ContextCompat.getColor(context,R.color.tiny_prints_blue));
        bottomColor = new ColorDrawable(ContextCompat.getColor(context,R.color.white));

        DrawableArray = new Drawable[]{
                topColor,
                bottomColor
        };

        layerdrawable = new LayerDrawable(DrawableArray);

        layerdrawable.setLayerInset(0,0,0,0,0);
        layerdrawable.setLayerInset(1,0,9,0,0);
    }

    public LayerDrawable getDrawableBackgroundItemTop(){
        return layerdrawable;
    }
}