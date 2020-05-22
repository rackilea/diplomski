import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class BorrowABook extends JFrame {

    private JPanel contentPane;
    private JTable table;
    private JButton button;
    private JLabel lblBookId;
    private JTextField textFieldBookID;
    private JLabel lblMemberId;
    private JTextField textFieldMemberID;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    BorrowABook frame = new BorrowABook();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public BorrowABook() {
        setTitle("Library system");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 971, 594);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        String data[][] = {{"1", "2", "3"}, {"4", "5", "6"}, {"7", "8", "9"}};
        String column[] = {"One", "Two", "Three" };
        DefaultTableModel model = new DefaultTableModel();
        // !! contentPane.setLayout(null);
        contentPane.setLayout(new BorderLayout());

        table = new JTable(data, column);
        JScrollPane sp = new JScrollPane(table);
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {

                int selectedRowIndex = table.getSelectedRow();
                textFieldBookID.setText(table.getModel().getValueAt(selectedRowIndex, 0).toString());
                textFieldMemberID.setText(table.getModel().getValueAt(selectedRowIndex, 1).toString());
            }
        });
        //!! sp.setBounds(5, 5, 936, 402);
        contentPane.add(sp);

        JPanel bottomPanel = new JPanel();

        lblBookId = new JLabel("Book ID:");
        lblBookId.setHorizontalAlignment(SwingConstants.RIGHT);
        lblBookId.setFont(new Font("Sitka Display", Font.BOLD, 22));
        bottomPanel.add(lblBookId);

        textFieldBookID = new JTextField();
        textFieldBookID.setColumns(10);
        textFieldBookID.setBounds(181, 420, 257, 29);
        bottomPanel.add(textFieldBookID);

        lblMemberId = new JLabel("Memeber ID:");
        lblMemberId.setHorizontalAlignment(SwingConstants.RIGHT);
        lblMemberId.setFont(new Font("Sitka Display", Font.BOLD, 22));
        lblMemberId.setBounds(28, 469, 141, 29);
        bottomPanel.add(lblMemberId);

        textFieldMemberID = new JTextField();
        textFieldMemberID.setColumns(10);
        textFieldMemberID.setBounds(181, 469, 257, 29);
        bottomPanel.add(textFieldMemberID);

        contentPane.add(bottomPanel, BorderLayout.PAGE_END);
    }
}