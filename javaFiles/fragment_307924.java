import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableColumnModelEvent;
import javax.swing.event.TableColumnModelListener;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class TableRowHeaderTest {

    public static void main(String[] args) {
        new TableRowHeaderTest();
    }

    public TableRowHeaderTest() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                Object rowData1[][]
                        = {
                            {"", "", "", ""},
                            {"", "", "", ""},
                            {"", "", "", ""},
                            {"", "", "", ""}
                        };

                Object columnNames1[] = {"HEADER 1", "HEADER 2", "HEADER 3", "HEADER 4"};

                JTable table1 = new TableWithRowHeader(rowData1, columnNames1);

                table1.getColumnModel().getColumn(0).setPreferredWidth(120);

                JScrollPane scrollPane1 = new JScrollPane(table1);
//                scrollPane1.setColumnHeaderView(null);

                JButton print = new JButton("Save");
                print.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        print(scrollPane1);
                    }
                });

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(scrollPane1);
                frame.add(print, BorderLayout.SOUTH);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    protected void print(JScrollPane scrollPane) {
        Component columnHeader = scrollPane.getColumnHeader().getView();
        Component rowHeader = scrollPane.getRowHeader().getView();
        Component view = scrollPane.getViewport().getView();

        int width = rowHeader.getPreferredSize().width + view.getPreferredSize().width;
        int height = columnHeader.getPreferredSize().height + view.getPreferredSize().height;

        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = img.createGraphics();
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, width, height);
        int xOffset = rowHeader.getPreferredSize().width;
        int yOffset = columnHeader.getPreferredSize().height;

        Graphics2D rowHeaderG = (Graphics2D) g2d.create();
        rowHeaderG.translate(0, yOffset);
        rowHeader.printAll(rowHeaderG);
        rowHeaderG.dispose();

        Graphics2D colHeaderG = (Graphics2D) g2d.create();
        colHeaderG.translate(xOffset, 0);
        columnHeader.printAll(colHeaderG);
        colHeaderG.dispose();

        Graphics2D viewG = (Graphics2D) g2d.create();
        viewG.translate(xOffset, yOffset);
        view.printAll(viewG);
        viewG.dispose();
        g2d.dispose();

        try {
            ImageIO.write(img, "png", new File("Test.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public class TableWithRowHeader extends JTable {

        private TableRowHeader rowHeader;

        public TableWithRowHeader(final Object[][] rowData, final Object[] columnNames) {
            super(rowData, columnNames);
            rowHeader = new TableRowHeader(this);
            setGridColor(Color.LIGHT_GRAY);
        }

        @Override
        protected void configureEnclosingScrollPane() {
            // This is required as it calls a private method...
            super.configureEnclosingScrollPane();

            Container parent = SwingUtilities.getUnwrappedParent(this);
            if (parent instanceof JViewport) {

                JViewport port = (JViewport) parent;
                Container gp = port.getParent();
                if (gp instanceof JScrollPane) {

                    JScrollPane scrollPane = (JScrollPane) gp;
                    JViewport viewport = scrollPane.getViewport();
                    if (viewport == null || SwingUtilities.getUnwrappedView(viewport) != this) {
                        return;
                    }
//                    scrollPane.setColumnHeaderView(null);
                    scrollPane.setRowHeaderView(rowHeader);
                }
            }
        }

    }

    public class TableRowHeader extends JTableHeader {

        private JTable table;

        public TableRowHeader(JTable table) {
            super(table.getColumnModel());
            this.table = table;

            table.getColumnModel().addColumnModelListener(new TableColumnModelListener() {

                @Override
                public void columnAdded(TableColumnModelEvent e) {
                    repaint();
                }

                @Override
                public void columnRemoved(TableColumnModelEvent e) {
                    repaint();
                }

                @Override
                public void columnMoved(TableColumnModelEvent e) {
                    repaint();
                }

                @Override
                public void columnMarginChanged(ChangeEvent e) {
                    repaint();
                }

                @Override
                public void columnSelectionChanged(ListSelectionEvent e) {
                    // Don't care about this, want to highlight the row...
                }
            });
            table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {
                    repaint();
                }
            });
        }

        public JTable getTable() {
            return table;
        }

        @Override
        public Dimension getPreferredSize() {
            Dimension size = new Dimension();
            JTable table = getTable();
            if (table != null) {
                TableColumnModel model = table.getColumnModel();
                if (model != null) {

                    for (int index = 0; index < model.getColumnCount(); index++) {

                        TableColumn column = model.getColumn(index);
                        TableCellRenderer renderer = column.getHeaderRenderer();
                        if (renderer == null) {

                            renderer = getDefaultRenderer();

                        }
                        Component comp = renderer.getTableCellRendererComponent(table, column.getHeaderValue(), false, false, -1, index);
                        size.width = Math.max(comp.getPreferredSize().width, size.width);
                        size.height += table.getRowHeight(index);

                    }

                }
            }
            return size;

        }

        /**
         * Overridden to avoid propagating a invalidate up the tree when the
         * cell renderer child is configured.
         */
        @Override
        public void invalidate() {
        }

        /**
         * If the specified component is already a child of this then we don't
         * bother doing anything - stacking order doesn't matter for cell
         * renderer components (CellRendererPane doesn't paint anyway).
         */
        @Override
        protected void addImpl(Component x, Object constraints, int index) {
            if (x.getParent() == this) {
                return;
            } else {
                super.addImpl(x, constraints, index);
            }
        }

        @Override
        protected void paintComponent(Graphics g) {

//            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();

            g2d.setColor(getBackground());
            g2d.fillRect(0, 0, getWidth(), getHeight());

            JTable table = getTable();
            if (table != null) {

                int width = getWidth();

                TableColumnModel model = table.getColumnModel();
                if (model != null) {

                    for (int index = 0; index < model.getColumnCount(); index++) {

                        TableColumn column = model.getColumn(index);
                        TableCellRenderer renderer = column.getHeaderRenderer();
                        if (renderer == null) {

                            renderer = getDefaultRenderer();

                        }

                        boolean selected = table.getSelectedRow() == index;

                        Component comp = renderer.getTableCellRendererComponent(table, column.getHeaderValue(), selected, false, 0, index);

                        add(comp);
                        comp.validate();

                        int height = table.getRowHeight(index) - 1;
                        comp.setBounds(0, 0, width, height);
                        comp.paint(g2d);
                        comp.setBounds(-width, -height, 0, 0);

                        g2d.setColor(table.getGridColor());
                        g2d.drawLine(0, height, width, height);

                        g2d.translate(0, height + 1);

                    }

                }
            }
            g2d.dispose();
            removeAll();
        }

    }

}