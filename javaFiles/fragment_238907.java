public class MyTextView extends TextView {

    public MyTextView (Context context) {
        super(context);
        if (!isInEditMode())
            init(context);
    }

    private void init(Context context) {
        setTypeface(Utils.getTypeface(context));
    }

    public MyTextView (Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        if (!isInEditMode())
            init(context);
    }

    public MyTextView (Context context, AttributeSet attrs) {
        super(context, attrs);
        if (!isInEditMode())
            init(context);
    }

}




public class Utils {
    private static Typeface tf;
public static Typeface getTypeface(Context ctx) {
        if (tf == null) {
            tf = Typeface.createFromAsset(ctx.getAssets(),
                    "fonts/HelveticaNeue.ttf");
        }
        return tf;
    }

    public static Typeface getDolphinTypeface(Context ctx) {
        return Typeface.createFromAsset(ctx.getAssets(), "fonts/GOTHIC.TTF");
    }
}