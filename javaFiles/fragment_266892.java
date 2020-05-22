public class MyCustomNumberEditor extends CustomNumberEditor {
   public void MyCustomNumberEditor(Class numberClass, boolean allowEmpty) {
      this.numberClass = numberClass;
      this.allowEmpty = allowEmpty;
   }

   @Override
   public void setAsText(String text) throws IllegalArgumentException {
      if (this.allowEmpty && !StringUtils.hasText(text)) {
      // Treat empty String as null value.
      setValue(null);
      }
      else {
         try {
            setValue(Convert.to(this.numberClass, text));
         }
         catch (Exception ex) {
            throw new IllegalArgumentException("Could not parse date: " + ex.getMessage(), ex);
         }
      }
   }
}