import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;



public class TestJTable {
private void init(){
    String[][] rowData = new String[][]{{"0","05:00"},{"1","08:00"},{"3","01:40"},{"4","01:30"},{"5","11:15"},{"6","12:10"}};

    String[][] columnNames = new String[][]{{},{}};
    final JTable table = new JTable(rowData, columnNames);

    JFrame frame = new JFrame();
    frame.setLayout(new BorderLayout());
    frame.add(table, BorderLayout.CENTER);

    JButton button = new JButton("Get Earliest Date");
    button.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String[] earliest = findEarliestTime(table).split(":");
            JOptionPane.showMessageDialog(null, "Earliest Hour " + earliest[0] + " , Minute : " + earliest[1]);
        }
    });

    frame.add(button, BorderLayout.SOUTH);
    frame.pack();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
}

private String findEarliestTime(JTable table) {
    String earliest = (String)table.getValueAt(0, 1);
    try {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        Date currentDate = null;
        Date earliestDate = null;
        String currentValue = null;
        for(int iDx = 1; iDx < table.getRowCount(); iDx++){
            currentValue = (String)table.getValueAt(iDx, 1);
            currentDate = sdf.parse(currentValue);
            earliestDate = sdf.parse(earliest);
            if(earliestDate.getTime() > currentDate.getTime()){
                earliest = currentValue;
            }
        }
    } catch (NumberFormatException e) {
        e.printStackTrace();
    } catch (ParseException e) {
        e.printStackTrace();
    }
    return String.valueOf(earliest);
}
public static void main(String[] args) {
    new TestJTable().init();
}