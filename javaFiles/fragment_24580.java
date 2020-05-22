import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class TagReplaceUI extends JFrame {

    private JPanel contentPane;
    private JTextField srcTextField;
    private Executor executor = Executors.newCachedThreadPool();
    private DefaultTableModel model = new DefaultTableModel();
    private JTable table = new JTable(model);

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    final TagReplaceUI frame = new TagReplaceUI();

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
    // FileDownloadTest downloadTest = new
    // FileDownloadTest(srcTextField.getText(), textArea);

    public TagReplaceUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 552, 358);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        srcTextField = new JTextField();
        srcTextField.setBounds(10, 26, 399, 20);
        contentPane.add(srcTextField);
        srcTextField.setColumns(10);

        JButton srcBtn = new JButton("Source Excel");
        srcBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fChoose = new JFileChooser();
                fChoose.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                if (fChoose.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                    srcTextField.setText(fChoose.getSelectedFile().getAbsolutePath());
                } else {
                    System.out.println("No Selection");
                }
            }
        });

        JScrollPane scroll = new JScrollPane(table);
        scroll.setBounds(10, 131, 516, 178);
        contentPane.add(scroll);
        model.addColumn("Col1");
        model.addColumn("Col2");

        srcBtn.setBounds(419, 25, 107, 23);
        contentPane.add(srcBtn);

        JButton dNcButton = new JButton("Process");
        dNcButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                executor.execute(new Test(srcTextField.getText(), model));
            }
        });
        dNcButton.setBounds(212, 70, 89, 23);
        contentPane.add(dNcButton);

    }

}