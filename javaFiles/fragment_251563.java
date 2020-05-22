public class ListScreen extends MainScreen implements FieldChangeListener {
   public ListScreen() {
      try {
         Vector data = new Vector();
         Bitmap icon = Bitmap.getBitmapResource("list_icon.png");
         for (int i = 0; i < 15; i++) {
            ListRander lr = new ListRander("Product Name " + i, icon);
            data.addElement(lr);
         }
         CustomListField list = new CustomListField(data);
         add(list);
         list.setChangeListener(this);
      } catch (Exception e) {
         e.printStackTrace();
      }
   }

   public void fieldChanged(Field field, int context) {
      if (field instanceof CustomListRow) {
         CustomListRow row = (CustomListRow) field;
         Dialog.alert(row.getData().getTitle() + " was selected!");
      }      
   }    
}