import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Example extends JFrame {

    private DefaultTableModel model;

    public Example() {
        JTable table = new JTable(model = new DefaultTableModel(new Object[][]{},new Object[]{"data"}));
        add(new JScrollPane(table));
        JButton populate = new JButton("populate");
        populate.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                //Pattern pattern = Pattern.compile(".*"+textArea.getText()+".*", Pattern.CASE_INSENSITIVE);
                //BasicDBObject query = new BasicDBObject("content:encoded", pattern);
                //DBCursor cursor = blogTable.find(query);
                //while (cursor.hasNext()) {
                //  model.addRow(new Object[]{cursor.next().toString()});
                //}

            }
        });
        add(populate,BorderLayout.NORTH);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Example frame = new Example();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}