import java.util.List;
import java.util.Random;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.AbstractTableModel;

public class TestTable {

    public JFrame f;
    private JTable table;

    public class ModelObject {
        private String column0; // Consider using something more explicit than column0,1,...
        private String column1;

        public String getColumn0() {
            return column0;
        }

        public void setColumn0(String column0) {
            this.column0 = column0;
        }

        public String getColumn1() {
            return column1;
        }

        public void setColumn1(String column1) {
            this.column1 = column1;
        }
    }

    private class TableModel extends AbstractTableModel {

        private List<ModelObject> data;

        protected TableModel(List<ModelObject> data) {
            super();
            this.data = data;
        }

        @Override
        public int getRowCount() {
            return data.size();
        }

        @Override
        public String getColumnName(int column) {
            switch (column) {
            case 0:
                return "Header 0";
            case 1:
                return "Header 1";
            }
            System.err.println("Only two columns are known in this table model");
            return "???";
        }

        @Override
        public int getColumnCount() {
            return 2;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            ModelObject o = data.get(rowIndex);
            switch (columnIndex) {
            case 0:
                return o.getColumn0();
            case 1:
                return o.getColumn1();
            }
            System.err.println("Only two columns are known in this table model");
            return null;
        }

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new TestTable().initUI();
            }
        });
    }

    protected void initUI() {
        Random r = new Random();
        Vector<ModelObject> data = new Vector<TestTable.ModelObject>();
        for (int i = 0; i < 10; i++) {
            ModelObject o = new ModelObject();
            o.setColumn0("Some stuff in column 0 " + i);
            o.setColumn1("Some other stuff in column 1 " + r.nextInt());
            data.add(o);
        }
        table = new JTable(new TableModel(data));
        f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(300, 300);
        f.setLocationRelativeTo(null);
        f.add(new JScrollPane(table));
        f.setVisible(true);
    }

}