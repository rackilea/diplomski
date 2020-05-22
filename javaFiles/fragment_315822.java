import java.awt.EventQueue;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/** @see https://stackoverflow.com/a/11237205/230513 */
public class MainJF extends JFrame {

    private JTable tagsJT;
    private TagsSelectionTableModel model;
    private static int COLUMN_CHECK = 0;
    private static int COLUMN_TAG_NAME = 1;
    private static int COLUMN_TAG_ID = 2;
    private static int COLUMN_EDIT_TAG = 3;
    private static int COLUMN_DELETE_TAG = 4;

    public MainJF() {
        this.add(new JScrollPane(createTagsTable()));
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private JTable createTagsTable() {

        String[] columnNames = {"0", "Tag", "2", "3", "4"};

        Object[][] data = new Object[10][columnNames.length];
        for (int i = 0; i < data.length; i++) {
            data[i][COLUMN_CHECK] = false;
            data[i][COLUMN_TAG_NAME] = "Tag " + i;
            data[i][COLUMN_TAG_ID] = i;
            data[i][COLUMN_EDIT_TAG] = "edit";
            data[i][COLUMN_DELETE_TAG] = "delete";
        }
        model = new TagsSelectionTableModel(columnNames, data);
        tagsJT = new JTable(model);
        tagsJT.setRowSelectionAllowed(true);
        tagsJT.addMouseListener(new TagsTableMA());
        return tagsJT;
    }

    class TagsSelectionTableModel extends DefaultTableModel {

        public TagsSelectionTableModel(String[] columnNames, Object[][] data) {
            super(data, columnNames);
        }
    }

    class TagsTableMA extends MouseAdapter {

        @Override
        public void mousePressed(MouseEvent e) {
            Point p = e.getPoint();
            int row = tagsJT.rowAtPoint(p);
            int col = tagsJT.columnAtPoint(p);
            if (col == COLUMN_DELETE_TAG) {
                model.removeRow(row);
            }
        }
    }

    public static void main(String args[]) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new MainJF().setVisible(true);
            }
        });
    }
}