import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.io.*;
import java.util.Vector;
import javax.swing.filechooser.FileSystemView;

public class ExecutableList {

    private JComponent ui = null;
    String exePathString = "C:\\Windows";
    String exeFileType = "exe";

    ExecutableList() {
        initUI();
    }

    public final void initUI() {
        if (ui != null) {
            return;
        }

        ui = new JPanel(new BorderLayout(4, 4));
        ui.setBorder(new EmptyBorder(4, 4, 4, 4));

        File[] fAll0 = new File(exePathString).listFiles();
        Vector<File> v = new Vector<>();
        for (File f0 : fAll0) {
            if (f0.isDirectory()) {
                FilenameFilter fNF = new FilenameFilter() {

                    @Override
                    public boolean accept(File dir, String name) {
                        return name.toLowerCase().endsWith("exe");
                    }
                };
                File[] fExe0 = f0.listFiles(fNF);
                System.out.println("fExe0: ");
                if (fExe0 != null 
                        ) {
                        //&& fExe0.length<100) {
                    System.out.println("fExe0: " + fExe0.length);
                    for (File f1 : fExe0) {
                        v.add(f1);
                    }
                }
            }
        }
        System.out.println("v.size(): " + v.size());
        DefaultListModel dlm = new DefaultListModel();
        for (File f : v) {
            dlm.addElement(f);
        }
        JList list = new JList(dlm);
        list.setCellRenderer(new File2CellRenderer());
        list.setVisibleRowCount(v.size()/5);
        list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        list.setFixedCellHeight(20);
        list.setFixedCellWidth(30);
        ui.add(new JScrollPane(
                list, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER));
    }

    public JComponent getUI() {
        return ui;
    }

    public static void main(String[] args) {
        Runnable r = () -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception useDefault) {
            }
            ExecutableList o = new ExecutableList();

            JFrame f = new JFrame(o.getClass().getSimpleName());
            f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            f.setLocationByPlatform(true);

            f.setContentPane(o.getUI());
            f.pack();
            Dimension d = f.getSize();
            d = new Dimension(d.width, d.height/3);
            f.setMinimumSize(d);
            f.setSize(d);

            f.setVisible(true);
        };
        SwingUtilities.invokeLater(r);
    }
}

/** A cell renderer for a File. */
class File2CellRenderer implements ListCellRenderer {

    private FileSystemView fileSystemView;

    private JLabel label;

    File2CellRenderer() {
        label = new JLabel();
        label.setOpaque(true);
        fileSystemView = FileSystemView.getFileSystemView();
    }

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        File file = (File)value;
        label.setIcon(fileSystemView.getSystemIcon(file));
        //label.setText(fileSystemView.getSystemDisplayName(file));
        label.setToolTipText(file.getName());

        if (isSelected) {
            label.setBackground(Color.RED);
            label.setForeground(Color.YELLOW);
        } else {
            label.setBackground(Color.WHITE);
            label.setForeground(Color.BLACK);
        }

        return label;
    }
}