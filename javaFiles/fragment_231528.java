public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        android.support.v7.widget.AppCompatButton button =
            new android.support.v7.widget.AppCompatButton(this, null, android.R.attr.buttonBarNeutralButtonStyle);
        Log.d("MainActivity", String.format("<<<< Button color = 0x%08X", button.getCurrentTextColor()));
        Log.d("MainActivity", String.format("<<<< Derived color = 0x%08X", getNeutralButtonColor(Color.WHITE)));
    }

    private int getNeutralButtonColor(int defaultColor) {
        TypedArray ta;
        int color = defaultColor;
        boolean colorFound = false;
        int textColorResId;
        final int baseAttr = R.attr.buttonBarNeutralButtonStyle;

        // Look for an explicit textColor attribute and use it if it is defined.
        ta = getTheme().obtainStyledAttributes(null, new int[]{android.R.attr.textColor}, baseAttr, 0);
        textColorResId = ta.getResourceId(0, -1);
        if (textColorResId == -1) { // try to get color if not resource id
            int type = ta.getType(0);
            if (type >= TypedValue.TYPE_FIRST_COLOR_INT && type <= TypedValue.TYPE_LAST_COLOR_INT) {
                color = ta.getColor(0, defaultColor);
                colorFound = true;
            }
        }
        ta.recycle();

        if (textColorResId == -1 && !colorFound) {
            // No color, yet. See if textAppearance is defined.
            ta = obtainStyledAttributes(null, new int[]{android.R.attr.textAppearance},
                                        baseAttr, 0);
            int textAppearanceId = ta.getResourceId(0, -1);
            if (textAppearanceId != -1) {
                // OK, textAppearance is defined. Get the embedded textColor.
                ta.recycle();
                ta = obtainStyledAttributes(textAppearanceId, new int[]{android.R.attr.textColor});
                textColorResId = ta.getResourceId(0, -1);
                if (textColorResId == -1) { // try to get color if not resource id
                    int type = ta.getType(0);
                    if (type >= TypedValue.TYPE_FIRST_COLOR_INT && type <= TypedValue.TYPE_LAST_COLOR_INT) {
                        color = ta.getColor(0, defaultColor);
                        colorFound = true;
                    }
                }
            }
            ta.recycle();
        }

        if (textColorResId != -1 && !colorFound) {
            ColorStateList colorStateList = AppCompatResources.getColorStateList(this, textColorResId);
            if (colorStateList != null) {
                color = colorStateList.getDefaultColor();
                colorFound = true; // in case needed later
            }
        }

        return color;
    }

    @SuppressWarnings("unused")
    private static final String TAG = "MainActivity";
}