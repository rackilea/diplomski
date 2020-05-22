import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Testing extends JFrame {

    private static final long serialVersionUID = 1L;
    private DefaultListModel listModel = new DefaultListModel();
    private JList list = new JList(listModel);
    private int currentSelectedRow = 0;
    private int xX = 0;

    public Testing() {
        setLocation(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        for (int x = 0; x < 9; x++) {
            listModel.addElement("" + x);
            xX++;
        }
        JScrollPane sp = new JScrollPane(list);
        add(sp, BorderLayout.CENTER);
        JButton btn1 = new JButton("Reset Model CastingModel");
        add(btn1, BorderLayout.NORTH);
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                list.clearSelection();
                DefaultListModel model = (DefaultListModel) list.getModel();
                model.removeAllElements(); 
                // note Swing GUI by default to freeze if is removed more that 
                // 999 elemets from the JList or its underlaying XxxListModel, 
                // to use repeatly Actions from SwingTimer on short period
                for (int x = 0; x < 9; x++) {
                    model.addElement("" + (x + xX));
                    xX++;
                }
                list.setModel(model);
            }
        });

        JButton btn2 = new JButton("Reset Model directly from Model");
        add(btn2, BorderLayout.SOUTH);
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                list.clearSelection();
                listModel.removeAllElements();
                for (int x = 0; x < 9; x++) {
                    listModel.addElement("" + (x + xX));
                    xX++;
                }
            }
        });
        pack();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Testing().setVisible(true);
            }
        });
    }
}