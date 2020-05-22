public class FontCustomButton extends ButtonRectangle {


 public FontCustomButton(Context context, AttributeSet attrs, int defStyleAttr) {
     super(context, attrs, defStyleAttr);
     setCustomFont(context);
 }

 private void setCustomFont(Context context) {
    try {
        Typeface face = Typeface.createFromAsset(context.getAssets(), "fonts/font_1.ttf");            
        Field field = ButtonRectangle.class.getDeclaredField("textButton");
        field.setAccessible(true);
        TextView textView = (TextView) field.get(this);
        textView.setTypeface(face);

    } catch (Exception e) {
        e.printStackTrace();
    }
 }

}