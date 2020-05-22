public class SpecialClickableSpan extends ClickableSpan {

    String text;

    public SpecialClickableSpan(String text){
         super();
         this.text = text;
    }

    @Override
    public void onClick(View widget) {
         Log.d(TAG, "onClick [" + text + "]");
    }
}