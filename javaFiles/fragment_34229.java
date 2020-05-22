public class TagListEditor extends PropertyEditorSupport {

   @Override
   public void setAsText(String text) throws IllegalArgumentException {
      TagList tagList = // parse from the text value
      setValue(tagList);
   }

   @Override
   public String getAsText() {
      TagList tagList = (TagList) getValue();
      return tagList.toString(); // or whatever
   }
}