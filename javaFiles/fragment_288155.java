package test;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.AbstractCellEditor;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.JTable;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.event.CaretListener;
import javax.swing.event.CaretEvent;
import javax.swing.JScrollPane;

public class Poligon extends JFrame {

    private JPanel contentPane;
    private JTable table;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Poligon frame = new Poligon();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Poligon() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);

        table = new JTable();
        table.setModel(new DataModel("12:34:00"));
        table.setDefaultRenderer(Date.class, new DateRenderer());
        table.setDefaultEditor(Date.class, new DateEditor());
        table.setRowHeight(35);

        scrollPane.setViewportView(table);


    }

}

class DateRenderer implements TableCellRenderer
{

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {

        JPanel c = new JPanel();

        if (value instanceof Date)
        {
            SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
            c.add(new JLabel(dateFormat.format(value)));
        }

        return c;
    }

}

class DateEditor extends AbstractCellEditor implements TableCellEditor
{

    private Object cellEditorValue;

    @Override
    public Object getCellEditorValue() {    
        return this.cellEditorValue;
    }

    public void setCellEditorValue(Object value)
    {
        this.cellEditorValue = value;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table,  Object value, boolean isSelected, int row, int col) 
    {   

        JPanel c = new JPanel();

        if (value instanceof Date)
        {
            final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");

            final JTextField textField = new JTextField();

            textField.setText(dateFormat.format(value));

            textField.addCaretListener(new CaretListenerForDate(this, textField));

            c.add(textField);       
        }

        return c;
    }

}

class CaretListenerForDate implements CaretListener
{       
    private JTextField textField;
    private DateEditor dateEditor;

    public CaretListenerForDate(DateEditor dateEditor, JTextField textField)
    {
        this.textField = textField;
        this.dateEditor = dateEditor;
    }

    public void caretUpdate(CaretEvent e) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm"); 
        try {
            dateEditor.setCellEditorValue(dateFormat.parse(textField.getText()));
        } catch (ParseException e1) {
            System.err.println(String.format("Worng date format! [%s] Error is [%s]", textField.getText(), e1.getMessage() ));
        }

    }                               
}

class DataModel extends AbstractTableModel
{

    private String timeString;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm"); 

    public DataModel(String time) {
        this.timeString = time;
    }

    @Override
    public int getRowCount() {
        return 1;
    }

    @Override
    public int getColumnCount() {
        return 1;
    }

    @Override
    public Class<?> getColumnClass(int col) {
        if (col >= 0) {
            return Date.class;
        } else {
            return null;
        }
    }

    @Override
    public boolean isCellEditable(int row, int col) 
    {
        return col >= 0;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        Date date = null;

        try {
            date = dateFormat.parse(timeString);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return date;
    }

    @Override
    public void setValueAt(Object aValue, int row, int col) {           

        this.timeString = dateFormat.format(aValue);

        this.fireTableCellUpdated(row, col);  
    }
}