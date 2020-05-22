public class MediaWebView extends WebView {

   public MediaWebView(Context context) {
       super(context);
   }

   public MediaWebView(Context context, AttributeSet attrs) {
       super(context, attrs);
   }

   public MediaWebView(Context context, AttributeSet attrs, int defStyleAttr) {
       super(context, attrs, defStyleAttr);
   }

   @Override
   protected void onWindowVisibilityChanged(int visibility) {
       if (visibility != View.GONE) super.onWindowVisibilityChanged(View.VISIBLE);
   }

}