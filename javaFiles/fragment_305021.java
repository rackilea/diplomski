public class MyTextView extends TextView{    
    public MyTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
         String size = attrs.getAttributeValue("http://schemas.android.com/apk/res/android", "textSize");
    } 
}