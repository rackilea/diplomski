import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/** @see http://stackoverflow.com/questions/5438516 */
public class Nodes extends AbstractTableModel {

    private List<Node> nodes = new ArrayList<Node>();

    @Override
    public int getRowCount() {
        return nodes.size();
    }

    @Override
    public int getColumnCount() {
        return 5; // A Node has five members
    }

    @Override
    public Object getValueAt(int row, int col) {
        Node node = nodes.get(row);
        switch (col) {
            case 0:
                return node.name;
            case 1:
                return node.value;
            case 2:
                return node.first;
            case 3:
                return node.second;
            case 4:
                return node.values;
            default:
                return null;
        }
    }

    @Override
    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }

    private class Node {

        private String name;
        private double value;
        private List<Node> first;
        private List<Node> second;
        private List<Double> values;
    }
}