public class FileAdder {

    public static void main(String[] args) {
        new FileAdder();
    }

    public FileAdder() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException ex) {
                } catch (InstantiationException ex) {
                } catch (IllegalAccessException ex) {
                } catch (UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Test");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new FileAdderPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class FileAdderPane extends JPanel {

        private JList fileList;
        private JFileChooser chooser;

        public FileAdderPane() {
            setLayout(new BorderLayout());

            fileList = new JList(new MyFileListModel());
            JButton addMore = new JButton("Add More");
            addMore.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (chooser == null) {
                        chooser = new JFileChooser();
                        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                        chooser.setMultiSelectionEnabled(true);
                    }
                    switch (chooser.showOpenDialog(FileAdderPane.this)) {
                        case JFileChooser.APPROVE_OPTION:
                            File[] files = chooser.getSelectedFiles();
                            if (files != null && files.length > 0) {
                                MyFileListModel model = (MyFileListModel) fileList.getModel();
                                for (File file : files) {
                                    model.add(file);
                                }
                            }
                            break;
                    }
                }
            });

            add(new JScrollPane(fileList));
            add(addMore, BorderLayout.SOUTH);
        }
    }

    public class MyFileListModel extends AbstractListModel {

        private List<File> files = new ArrayList<File>(25);

        @Override
        public int getSize() {
            return files.size();
        }

        @Override
        public Object getElementAt(int index) {
            return files.get(index);
        }

        public void add(File file) {
            files.add(file);
            fireIntervalAdded(this, files.size() - 1, files.size() - 1);
        }

        public void remove(File file) {
            int index = files.indexOf(file);
            files.remove(file);
            fireIntervalRemoved(this, index, index);
        }
    }
}