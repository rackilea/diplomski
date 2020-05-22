import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;

public class TC extends JFrame{
    JComboBox<String> combo;
    JTable table;
    public TC(){
        begin();
    }
    public void begin(){
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("nothing.");
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(new String[] {"One", "Two", "Three"});
        combo = new JComboBox<>(model);
        table = new JTable(new Object[2][2], new String[] {"Column One", "Column Two"});
        TableColumn col0 = table.getColumnModel().getColumn(0);
        col0.setCellEditor(new DefaultCellEditor(combo));

        JButton button = new JButton("Clear");
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < table.getModel().getRowCount(); i++) {
                    table.setValueAt(combo.getModel().getElementAt(0), i, 0);
                }
            }
        });


        getContentPane().setLayout(null);
//      getContentPane().setLayout(new MigLayout());

        setPreferredSize(new Dimension(500,500));
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(0,0,300,100);
        getContentPane().add(sp);
        button.setBounds(300,100,200,200);
        getContentPane().add(button);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable(){

            @Override
            public void run() {
                TC tc = new TC();

            }

        });
    }
}