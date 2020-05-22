import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.plaf.basic.ComboPopup;
import javax.swing.table.DefaultTableModel;

public class TableComboBoxMain {
    public static void main(String[] args) {
        JTableComboBox<String> combo = new JTableComboBox<>();
        combo.addItem("");
        BasicComboBoxUI ui = new BasicComboBoxUI(){
            @Override
            protected ComboPopup createPopup() {
                return new BasicComboPopup( comboBox ){
                    @Override
                    protected int getPopupHeightForRowCount(int maxRowCount) {
                        return 100;
                    }
                    @Override
                    protected JScrollPane createScroller() {
                        JScrollPane sp = new JScrollPane( list,
                            ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
                            ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED );
                        sp.getHorizontalScrollBar().setFocusable( false );
                        return sp;
                    }
                };
            }
        };
        combo.setUI(ui);
        combo.setRenderer(new TableListCellRenderer(combo));
        JFrame frame = new JFrame("Test Table Combo Box");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(combo);
        frame.pack();
        frame.setVisible(true);
    }

    public static class Employee{
        String name;
        int nr;
        public Employee(String name, int number ){
            this.name =name;
            this.nr = number;
        }
    }

    public static class JTableComboBox<E> extends JComboBox<E> implements ListSelectionListener{
        @Override
        public void valueChanged(ListSelectionEvent e) {
            System.out.println("Row selected"+e.getFirstIndex());
            this.setSelectedIndex(e.getFirstIndex());
        }
    }

    public static class TableListCellRenderer extends DefaultListCellRenderer{
        JTable table;
        JTableComboBox combo;
        JPanel renderer = new JPanel();
        JPanel colHeader = new JPanel();
        JScrollPane scroll = new JScrollPane();
        boolean mouseListenerAdded;
        public TableListCellRenderer(JTableComboBox combo){
            this.combo=combo;
            DefaultTableModel model = new DefaultTableModel();
            String[] cols1 = new String[]{"1","2","3","4","5","6"};
            String[] cols2 = new String[]{"Mark","John","April","Mary","Joe","Jack"};
            model.addColumn("Nr", cols1);model.addColumn("Name",cols2);
            table = new JTable(model);
            table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            colHeader.add(table.getTableHeader());
            renderer.setLayout(new BorderLayout());
            renderer.add(colHeader, BorderLayout.NORTH);
            renderer.add(table,BorderLayout.CENTER);
            scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
            scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
            scroll.getViewport().add(table);

        }
        @Override
        public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            list.setFixedCellHeight(table.getRowHeight()*(table.getRowCount()+1)+10);
            list.setFixedCellWidth(table.getPreferredSize().width);
            JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            if(!mouseListenerAdded){
                list.addMouseListener(this.getListener());
                mouseListenerAdded = true;
            }
            if(!combo.isPopupVisible()){
                label.setText("Select...");
                if(table.getSelectedRowCount()>0)
                    label.setText(""+table.getModel().getValueAt(table.getSelectedRow(),1));
                return label;
            }
               return scroll;
        }

        public MouseAdapter getListener(){
            MouseAdapter adapter = new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e) {
                    if(combo.isPopupVisible()){
                        System.out.println("MouseClicked over list");
                        int row = table.rowAtPoint(e.getPoint());
                        if(row>0){
                            table.setRowSelectionInterval(row-1, row-1);
                            ListDataEvent event = new ListDataEvent(combo,ListDataEvent.CONTENTS_CHANGED,row-1,row-1);
                            combo.contentsChanged(event);
                        }
                    }
                }
            };
            return adapter;
        }
    }
}