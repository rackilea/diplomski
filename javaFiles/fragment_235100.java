import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class TableSetEx 
{

    static JTable pref_table;

    public static void main(String[] args) {
        pref_table = new javax.swing.JTable();

        pref_table.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {
            {"MONDAY", null, null, null, null},
            {"TUESDAY", null, null, null, null},
            {"WEDNESDAY", null, null, null, null},
            {"THURSDAY", null, null, null, null},
            {"FRIDAY", null, null, null, null},
            {"SATURDAY", null, null, null, null}
        },
        new String [] {
            "DAY", "9 A.M-11 A.M", "11 A.M-1 P.M", "1 P.M-3 P.M", "3 P.M-5 P.M"
        }
        ) {
            Class[] types = new Class [] {
            java.lang.String.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class
        };

        public Class getColumnClass(int columnIndex) {
            return types [columnIndex];
        }
        });

        JButton button = new JButton("Click");
        button.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent arg0) {
                // Some hardceded cell.
                set_tab_val(true,2,3);
            }
        });

        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());
        frame.add(new JScrollPane(pref_table), BorderLayout.NORTH);
        frame.add(button, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }

    public static void set_tab_val(boolean x,int r,int c)
    {
      pref_table.setValueAt(true,r,c);
    }
}