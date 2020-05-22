public class DropTable {

    public static void main(String[] args) {
        new DropTable();
    }

    public DropTable() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new DropPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }

        });
    }

    public class DropPane extends JPanel {

        private JTable table;
        private JScrollPane scroll;
        private DefaultTableModel tm = new DefaultTableModel(new String[]{"File", "File Type", "Size", "Status"}, 0);

        public DropPane() {
            table = new JTable();
            table.setShowGrid(true);
            table.setShowHorizontalLines(true);
            table.setShowVerticalLines(true);
            table.setGridColor(Color.GRAY);

            table.setModel(tm);
            table.setFillsViewportHeight(true);
            table.setPreferredSize(new Dimension(500, 300));

            scroll = new JScrollPane(table);

            table.setDropTarget(new DropTarget() {
                @Override
                public synchronized void dragOver(DropTargetDragEvent dtde) {
                    Point point = dtde.getLocation();
                    int row = table.rowAtPoint(point);
                    if (row < 0) {
                        table.clearSelection();
                    } else {
                        table.setRowSelectionInterval(row, row);
                    }
                    dtde.acceptDrag(DnDConstants.ACTION_COPY_OR_MOVE);
                }

                @Override
                public synchronized void drop(DropTargetDropEvent dtde) {
                    if (dtde.isDataFlavorSupported(DataFlavor.javaFileListFlavor)) {
                        dtde.acceptDrop(DnDConstants.ACTION_COPY_OR_MOVE);
                        Transferable t = dtde.getTransferable();
                        List fileList = null;
                        try {
                            fileList = (List) t.getTransferData(DataFlavor.javaFileListFlavor);
                            if (fileList.size() > 0) {
                                table.clearSelection();
                                Point point = dtde.getLocation();
                                int row = table.rowAtPoint(point);
                                DefaultTableModel model = (DefaultTableModel) table.getModel();
                                for (Object value : fileList) {
                                    if (value instanceof File) {
                                        File f = (File) value;
                                        if (row < 0) {
                                            model.addRow(new Object[]{f.getAbsolutePath(), "", f.length(), "", ""});
                                        } else {
                                            model.insertRow(row, new Object[]{f.getAbsolutePath(), "", f.length(), "", ""});
                                            row++;
                                        }
                                    }
                                }
                            }
                        } catch (UnsupportedFlavorException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else {
                        dtde.rejectDrop();
                    }
                }

            });

            add(scroll, BorderLayout.CENTER);
        }
    }
}