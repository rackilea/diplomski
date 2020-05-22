import java.awt.Dimension;
import java.awt.GridLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;

public class JSplitPaneToy {

    public static void main(String[] args) {
        JSplitPane sp = new JSplitPane(JSplitPane.VERTICAL_SPLIT, makePanel(), makePanel());
        JPanel pnl = new JPanel();
        pnl.setLayout(new GridLayout(4, 1, 10, 10));
        pnl.add(makePanel());
        pnl.add(makePanel());
        pnl.add(makePanel());
        pnl.add(makePanel());
        PropertyChangeListener propertyChangeListener = new PropertyChangeListener() {

            public void propertyChange(PropertyChangeEvent changeEvent) {
                JSplitPane sourceSplitPane = (JSplitPane) changeEvent.getSource();
                String propertyName = changeEvent.getPropertyName();
                if (propertyName.equals(JSplitPane.LAST_DIVIDER_LOCATION_PROPERTY)) {
                    int current = sourceSplitPane.getDividerLocation();
                    System.out.println("Current: " + current);
                    Integer last = (Integer) changeEvent.getNewValue();
                    System.out.println("Last: " + last);
                    Integer priorLast = (Integer) changeEvent.getOldValue();
                    System.out.println("Prior last: " + priorLast);
                }else if (propertyName.equals(JSplitPane.RESIZE_WEIGHT_PROPERTY)) {
                    int current = sourceSplitPane.getDividerLocation();
                    System.out.println("Current: " + current);
                    Integer last = (Integer) changeEvent.getNewValue();
                    System.out.println("Last: " + last);
                    Integer priorLast = (Integer) changeEvent.getOldValue();
                    System.out.println("Prior last: " + priorLast);
                }
            }
        };
        sp.addPropertyChangeListener(propertyChangeListener);
        JFrame frame = new JFrame("JSplitPane Toy");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(0, 2, 10, 10));
        frame.add(sp);
        frame.add(pnl);
        frame.pack();
        frame.setVisible(true);
    }

    private static JScrollPane makePanel() {
        JScrollPane pane = new JScrollPane(new JTable(
                new Object[][]{{0, 1, 2}, {1, 2, 3}, {2, 3, 4}}, new Object[]{1, 2, 3}));
        pane.setPreferredSize(new Dimension(200, 100));
        return pane;
    }
}