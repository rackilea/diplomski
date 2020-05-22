import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.AbstractTableModel;

public class DataPanel  extends JPanel{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private static final int ROW_HEIGHT = 18;

    List<String> data = new ArrayList<String>();
    List<JTable> tables = new ArrayList<JTable>();
    JScrollPane scrollPane;
    JTable table, lastTable;
    JPanel boxPanel;
    JFrame f;
    int rows = 0;

    public DataPanel()
    {
        for (int i = 0; i < 50; i++)
            data.add("Blah " + i);
        DataModel tableData = new DataModel(data);
        tableData.setData(data);
        setLayout(new BorderLayout());
        /*JButton btn = new JButton("Action");
        btn.addActionListener(new ActionListener()
        {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                addTable();
            }

        });
        add(btn, BorderLayout.NORTH);*/
        boxPanel = new JPanel();
        boxPanel.setLayout(new BoxLayout(boxPanel, BoxLayout.X_AXIS));
        addTable();
        add(boxPanel, BorderLayout.CENTER);
        f = new JFrame();
        f.getContentPane().add(this);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(500,500);
        f.setVisible(true);
        f.addComponentListener(adapter);
    }

    protected void addTable() {
        // TODO Auto-generated method stub
        while (rows < data.size())
        {
            System.out.println("Querying " + rows);
            List<String> newData = getData(rows);
            rows += getVisibleRowCount();
            DataModel newModel = new DataModel(newData);
            JTable newTable = new JTable(newModel);
            lastTable = newTable;
            newTable.setRowHeight(ROW_HEIGHT);
            JScrollPane newScrollPane = new JScrollPane(newTable);
            tables.add(newTable);
            newScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
            boxPanel.add(newScrollPane);
            System.out.println("Now " + rows);
        }
    }

    private ComponentAdapter adapter = new ComponentAdapter()
    {

        @Override
        public void componentResized(ComponentEvent arg0) {
            // TODO Auto-generated method stub
            //super.componentResized(arg0);
            rows = 0;
            for (JTable eachTable : tables)
            {
                List<String> newData = getData(rows);
                rows += getVisibleRowCount();
                DataModel newModel = new DataModel(newData);
                eachTable.setModel(newModel);
                ((DataModel)eachTable.getModel()).fireTableDataChanged();
            }
        }

    };

    private List<String> getData(int rows) {
        // TODO Auto-generated method stub
        List<String> newData = new ArrayList<String>();
        int j = 0;
        for(int i=0; i<data.size() && j < getVisibleRowCount(); i++)
        {
            if (i >= rows)
            {
                newData.add(data.get(i));
                j++;
            }
        }
        return newData;
    }

    private int getVisibleRowCount()
    {
        Dimension extentSize = null;
        int visibleRows = 12;
        if (null != f)
        {
            extentSize = f.getSize();
            visibleRows = (extentSize.height - 50)/ROW_HEIGHT;
        }
        return visibleRows;
    }

    public static void main(String args[])
    {
        new DataPanel();
    }

    private class DataModel extends AbstractTableModel{

        static final int COL1_INDEX = 0;
        static final int COL2_INDEX = 1;

        private final String[] COLUMN_NAMES = new String[]
                //LM2 - B & O abbreviations to be replaced by B & S. - HP   17e9355d63
                //LM2 - brokers should be able to see trader names in the order panel - HP  e4fbaa791a
                {"ID", "Name"};

        private List<String> data = new ArrayList<String>();

        public DataModel(List<String> newData)
        {
            data = newData;
        }

        public List<String> getData() {
            return data;
        }

        public void setData(List<String> data) {
            this.data = data;
        }

        @Override
        public int getColumnCount() {
            // TODO Auto-generated method stub
            return COLUMN_NAMES.length;
        }

        @Override
        public int getRowCount() {
            // TODO Auto-generated method stub
            if (null == data)
                return 0;
            return data.size();
        }

        @Override
        public Object getValueAt(int row, int col) {
            // TODO Auto-generated method stub
            if (col == COL1_INDEX)
            {
                return row;
            }else
            {
                return data.get(row);
            }
        }

        @Override
        public String getColumnName(int column) {
            // TODO Auto-generated method stub
            return COLUMN_NAMES[column];
        }

    }

}