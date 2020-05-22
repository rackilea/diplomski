import java.awt.EventQueue;
import java.text.DateFormat;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.TableColumn;
import org.jdesktop.swingx.table.DatePickerCellEditor;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }
                JTable table = new JTable(new Object[][]{{"1", new Date()}},
                                new Object[]{"Id", "Time"});

                TableColumn dateColumn = table.getColumnModel().getColumn(1);
                BoundDatePickerCellEditor picker = new BoundDatePickerCellEditor();
                picker.setLowerBound(new Date());
                dateColumn.setCellEditor(picker);

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new JScrollPane(table));
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class BoundDatePickerCellEditor extends DatePickerCellEditor {

        public BoundDatePickerCellEditor() {
            super();
        }

        public BoundDatePickerCellEditor(DateFormat dateFormat) {
            super(dateFormat);
        }

        public void setLowerBound(Date date) {
            datePicker.getMonthView().setLowerBound(date);
        }

        public void setUpperBound(Date date) {
            datePicker.getMonthView().setLowerBound(date);
        }

    }
}