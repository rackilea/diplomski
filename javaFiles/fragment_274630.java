import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.my.classes.Validation;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class SearchBooks extends JFrame {

    private JPanel contentPane;
    private JTextField txtIsbn;
    private Validation v = new Validation();
    private JTable table;
    DefaultTableModel dtm ;
    Object[]  row = {"hi", "2", "3", "5", "r", "we" };


    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SearchBooks frame = new SearchBooks();
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
    public SearchBooks() {
        setTitle("Search Books from Database");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        //setBounds(100, 100, 502, 341); instead of it use pack() see below it's uses at right place not here...
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        //contentPane.setLayout(null);

        JLabel lblBookName = new JLabel("Book Name: ");
        lblBookName.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblBookName.setBounds(23, 11, 80, 14);
        contentPane.add(lblBookName);

        txtIsbn = new JTextField();
        txtIsbn.setBounds(113, 8, 202, 20);
        contentPane.add(txtIsbn);
        txtIsbn.setColumns(10);

        JButton btnSearch = new JButton("Search");
        btnSearch.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnSearch.setBounds(338, 7, 103, 23);
        contentPane.add(btnSearch);

        Object[] title = {"ISBN", "Name", "Author", "Shelf No", "Row No", "Col No"};
        dtm = new DefaultTableModel(); 
        dtm.setColumnIdentifiers(title);
        table = new JTable(dtm);
        table.setBounds(23, 55, 435, 217);
        table.setModel(dtm);
        //JScrollPane scroll = new JScrollPane(table, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        JScrollPane scroll = new JScrollPane(table);
        table.setFillsViewportHeight(true);
        table.setForeground(Color.RED);
        table.setRowHeight(30);
        contentPane.add(scroll);

        // contentPane.add(table); //comment it...

        //dtm.addRow(title); doesn't required because already header is there...
        pack();

        txtIsbn.addKeyListener(
                new KeyAdapter() {
                    public void keyPressed(KeyEvent ev) {
                        if(ev.getKeyCode() == KeyEvent.VK_ENTER) {

                            if(v.validateIsbn(txtIsbn.getText())  || v.validateAddress(txtIsbn.getText())) {

                            }else {
                                JOptionPane.showMessageDialog(null, "Error! Please check your input");
                            }
                        }
                    }
                });

        btnSearch.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        table.setForeground(Color.BLACK);
                        dtm.addRow(row);

                    }
                });
    }
}