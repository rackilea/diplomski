package main;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.AbstractListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListCellRenderer;
import javax.swing.ListModel;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

class RowHeaderRenderer extends JLabel implements ListCellRenderer {

  RowHeaderRenderer(JTable table) {
    JTableHeader header = table.getTableHeader();
    setOpaque(true);
    setBorder(UIManager.getBorder("TableHeader.cellBorder"));
    setHorizontalAlignment(CENTER);
    setForeground(header.getForeground());
    setBackground(header.getBackground());
    setFont(header.getFont());
  }

  @Override
  public Component getListCellRendererComponent(JList list, Object value,
      int index, boolean isSelected, boolean cellHasFocus) {
    setText((value == null) ? "" : value.toString());
    return this;
  }
}

public class RowHeaderTable extends JFrame {

  public RowHeaderTable() {
    super("Row Header Example");
    setSize(300, 150);

    ListModel lm = new AbstractListModel() {
      String headers[] = { "a", "b", "c", "d", "e", "f", "g", "h", "i" };

      @Override
      public int getSize() {
        return headers.length;
      }

      @Override
      public Object getElementAt(int index) {
        return headers[index];
      }
    };    

    DefaultTableModel dm = new DefaultTableModel(lm.getSize(), 15);
    JTable table = new JTable(dm);
    table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

    JList rowHeader = new JList(lm);
    rowHeader.setFixedCellWidth(50);

    // ***************  CODE ADDED  *******************
    // Add a Mouse Motion Listener for the rowHeader JList.
    rowHeader.addMouseMotionListener(new MouseMotionListener() {
        @Override
        public void mouseDragged(MouseEvent e) {
            // Set the list cell width as mouse is dragged.
            rowHeader.setFixedCellWidth(e.getX());
      }

        @Override
        public void mouseMoved(MouseEvent e) {
            // If the mouse pointer is near the end region of the 
            // list cell then change the mouse cursor to a resize cursor.
            if ((e.getX()>= (rowHeader.getWidth() - 5)) && (e.getX()<= rowHeader.getWidth())) {
                rowHeader.setCursor(new Cursor(Cursor.E_RESIZE_CURSOR));
            } 
            // If the mouse pointer is not near the end region of a cell 
            // then change the pointer back to its default.
            else {
                rowHeader.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        }
    });
    // ***********************************************  

    rowHeader.setFixedCellHeight(table.getRowHeight()
        + table.getRowMargin());
    //  + table.getIntercellSpacing().height);
    rowHeader.setCellRenderer(new RowHeaderRenderer(table));

    JScrollPane scroll = new JScrollPane(table);
    scroll.setRowHeaderView(rowHeader);
    getContentPane().add(scroll, BorderLayout.CENTER);
  }

  public static void main(String[] args) {
      RowHeaderTable frame = new RowHeaderTable();
    frame.addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });
    frame.setVisible(true);
  }
}