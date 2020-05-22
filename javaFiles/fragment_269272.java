import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileSystemView;

public class TestFileChooser {

    public static void main(String[] args) {
        new TestFileChooser();
    }

    public TestFileChooser() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        private JFileChooser fc;
        private RectentFileList rectentFileList;

        public TestPane() {
            setLayout(new GridBagLayout());
            JButton chooser = new JButton("Choose");
            chooser.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (fc == null) {
                        fc = new JFileChooser();
                        rectentFileList = new RectentFileList(fc);
                        fc.setAccessory(rectentFileList);
                        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
                    }
                    switch (fc.showOpenDialog(TestPane.this)) {
                        case JOptionPane.OK_OPTION:
                            File file = fc.getSelectedFile();
                            rectentFileList.add(file);
                            break;
                    }
                }
            });
            add(chooser);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }
    }

    public class RectentFileList extends JPanel {

        private final JList<File> list;
        private final FileListModel listModel;
        private final JFileChooser fileChooser;

        public RectentFileList(JFileChooser chooser) {
            fileChooser = chooser;
            listModel = new FileListModel();
            list = new JList<>(listModel);
            list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            list.setCellRenderer(new FileListCellRenderer());

            setLayout(new BorderLayout());
            add(new JScrollPane(list));

            list.addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {
                    if (!e.getValueIsAdjusting()) {
                        File file = list.getSelectedValue();
                        // You might like to check to see if the file still exists...
                        fileChooser.setSelectedFile(file);
                    }
                }
            });
        }

        public void clearList() {
            listModel.clear();
        }

        public void add(File file) {
            listModel.add(file);
        }

        public class FileListModel extends AbstractListModel<File> {

            private List<File> files;

            public FileListModel() {
                files = new ArrayList<>();
            }

            public void add(File file) {
                if (!files.contains(file)) {
                    if (files.isEmpty()) {
                        files.add(file);
                    } else {
                        files.add(0, file);
                    }
                    fireIntervalAdded(this, 0, 0);
                }
            }

            public void clear() {
                int size = files.size() - 1;
                if (size >= 0) {
                    files.clear();
                    fireIntervalRemoved(this, 0, size);
                }
            }

            @Override
            public int getSize() {
                return files.size();
            }

            @Override
            public File getElementAt(int index) {
                return files.get(index);
            }
        }

        public class FileListCellRenderer extends DefaultListCellRenderer {

            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (value instanceof File) {
                    File file = (File) value;
                    Icon ico = FileSystemView.getFileSystemView().getSystemIcon(file);
                    setIcon(ico);
                    setToolTipText(file.getParent());
                    setText(file.getName());
                }
                return this;
            }

        }

    }

}