import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

    public class StackExample {

        public static void main(String[] args) {

            MyTableModel model = new MyTableModel("This is some string that I want to show");

            // Create a JTable and tell it to display our model
            JTable table = new JTable(model);

            // Display it all in a scrolling window and make the window appear
            JFrame frame = new JFrame("FileTableDemo");
            frame.getContentPane().add(new JScrollPane(table), "Center");
            frame.setSize(600, 400);
            frame.setVisible(true);
        }
    }