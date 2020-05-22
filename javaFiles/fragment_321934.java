public class TestActivity implement GetTextCallback {
   public interface GetTextCallback {
       String getText()
   }

   @Override
   public String getText() {
       return editText.getText().toString();
   }
}