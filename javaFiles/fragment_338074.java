import java.awt.EventQueue;
import java.awt.event.*;
import javax.swing.*;

// Custom class to extend our JList and expose tooltip functionality.
class MyList extends JList {

    public MyList() {
        super();

        // Attach a mouse motion adapter to let us know the mouse is over an item and to show the tip.
        addMouseMotionListener(new MouseMotionAdapter() {

            @Override
            public void mouseMoved(MouseEvent e) {
                MyList theList = (MyList) e.getSource();
                ListModel model = theList.getModel();
                int index = theList.locationToIndex(e.getPoint());
                if (index > -1) {
                    theList.setToolTipText(null);
                    String text = (String) model.getElementAt(index);
                    theList.setToolTipText(text);
                }
            }
        });
    }

    // Expose the getToolTipText event of our JList
    public String getToolTipText(MouseEvent e) {
        return super.getToolTipText();
    }
}

public class TestJList extends JFrame {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                TestJList myTest = new TestJList();
                myTest.setTitle("Example JList");
                myTest.setSize(300, 300);
                myTest.setDefaultCloseOperation(EXIT_ON_CLOSE);

                MyList list = new MyList();

                // Create our model and add some items.
                DefaultListModel model = new DefaultListModel();

                model.addElement("one");
                model.addElement("two");
                model.addElement("three");
                model.addElement("four");

                // Set the model for our list
                list.setModel(model);

                ToolTipManager.sharedInstance().registerComponent(list);

                // Add our custom list and show the form.
                MyTest.add(list);
                MyTest.setVisible(true);
            }
        });
    }
}