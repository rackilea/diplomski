import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.plaf.basic.BasicComboBoxEditor;

public class TestComboScroll {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Scroll inside Combo");
        JComboBox combobox = new JComboBox();

        combobox.addItem("");
        combobox.addItem("Item1");
        combobox.addItem("Item2 Item2 Item2 Item2 Item2 Item2 Item2 Item2 Item2 Item2 Item2 Item2 Item2 Item2");
        combobox.addItem("Item3");

        combobox.setEditor(new MyEditor());
        combobox.setEditable(true);

        combobox.setPreferredSize(new Dimension(200, 50));
        frame.add(combobox);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    static class MyEditor extends BasicComboBoxEditor{
        JScrollPane scroller = new JScrollPane();
        //NOTE: editor is a JTextField defined in BasicComboBoxEditor

        public MyEditor(){
            super();
            scroller.setViewportView(editor); 
            scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        }

        /** Return a JScrollPane containing the JTextField instead of the JTextField **/
        @Override
        public Component getEditorComponent() {
            return scroller;
        }

        /** Override to create your own JTextField. **/
        @Override
        protected JTextField createEditorComponent() {
            JTextField editor = new JTextField();
            editor.setBorder(null);
            /*editor.setEditable(false); //If you want it not to be editable */
            return editor;
        }
    }
}