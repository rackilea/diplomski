public class FontHelper {

    private static final String FONT_PATH = "fonts/OpenSans-Bold.ttf";

    public static Typeface getCustomTypeFace(Context context) {
        return Typeface.createFromAsset(context.getAssets(), FONT_PATH);
    }
}