import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

public class ListTest {

    public static void main(String[] args) {

    }

    public class InfoNameListCellRenderer extends DefaultListCellRenderer {

        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            if (value instanceof Info) {
                Info info = (Info)value;
                value = info.getName(); // Or what ever getter you have available for such things
            }
            return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus); 
        }



    }

}