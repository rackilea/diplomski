import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

public class FileManager extends JFrame implements Runnable {

    JPanel mainPanel;
    JTabbedPane viewerPane;
    DefaultTableModel model;
    JTable table;
    String col[] = {"File Name", "Date Added"};
    ArrayList<String> uploadedFiles = new ArrayList<>();
    File currentFile;
    File savedFile;

    public FileManager() {
        super("File Managment System");
        currentFile = null;
        savedFile = null;
        mainPanel = new JPanel();
        viewerPane = new JTabbedPane();
    }

    @Override
    public void run() {
        uploadedFiles.add("C:\\");
        model = new DefaultTableModel(col, uploadedFiles.size()) {
            @Override
            public boolean isCellEditable(int arg0, int arg1) {
                return false;
            }
        };
        table = new JTable(model);
        table.getTableHeader().setReorderingAllowed(false);
        makeTable();
        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int row = table.getSelectedRow();
                    viewerPane.add((String) table.getValueAt(row, 0), new JPanel());
                    viewerPane.setSelectedIndex(viewerPane.getComponentCount()-1);
                }
            }
        });
        mainPanel.setLayout(new GridLayout(1, 2));
        viewerPane.add("Files", table);
        mainPanel.add(viewerPane);
        getContentPane().add(mainPanel);
        setSize(1200, 700);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void makeTable() {
        int k = 0;
        for (String s : uploadedFiles) {
            table.setValueAt(s, k, 0);
            table.setValueAt(LocalDate.now(), k, 1);
            k++;
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new FileManager());
    }
}