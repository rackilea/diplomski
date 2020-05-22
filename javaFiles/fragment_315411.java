import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;

public class NewComboBox extends JComboBox {
   private Object previousSelectedItem = null;
   private int previousSelectedIndex = -1;

   public Object getPreviousSelectedItem() {
      return previousSelectedItem;
   }

   public int getPreviousSelectedIndex() {
      return previousSelectedIndex;
   }

   NewComboBox(ComboBoxModel aModel) {
      super(aModel);
   }

   @Override
   public void setSelectedIndex(int anIndex) {
      previousSelectedIndex = getSelectedIndex();
      previousSelectedItem = getSelectedItem();
      super.setSelectedIndex(anIndex);
   }

   @Override
   public void setSelectedItem(Object anObject) {
      previousSelectedIndex = getSelectedIndex();
      previousSelectedItem = getSelectedItem();
      super.setSelectedItem(anObject);
   }

}