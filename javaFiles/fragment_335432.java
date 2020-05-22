import java.awt.*;
import java.awt.event.*;
import java.util.Optional;
import javax.swing.*;
import javax.swing.table.*;

public class Main2 {
  public JComponent makeUI() {
    Object columnNames[] = {"Column 1", "Column 2", "Column 3"};
    Object data[][] = {
      { "a", "a", "a" },
      { "a", "a", "a" },
      { "a", "a", "a" },
      { "a", "a", "a" },
      { "a", "a", "a" },
    };
    JTable table = new JTable(new DefaultTableModel(data, columnNames));
    table.setDragEnabled(true);
    table.setDropMode(DropMode.INSERT_ROWS);
    table.addMouseMotionListener(new MouseAdapter() {
      @Override public void mouseDragged(MouseEvent e) {
        JComponent c = (JComponent) e.getComponent();
        Optional.ofNullable(c.getTransferHandler())
                .ifPresent(th -> th.exportAsDrag(c, e, TransferHandler.COPY));
      }
    });
    table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
    table.setColumnSelectionAllowed(true);
    table.setRowSelectionAllowed(true);

    JPanel p = new JPanel(new BorderLayout());
    p.add(new JScrollPane(table));
    p.add(new JTextField(), BorderLayout.SOUTH);
    return p;
  }
  public static void main(String... args) {
    EventQueue.invokeLater(() -> {
      JFrame f = new JFrame();
      f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      f.getContentPane().add(new Main2().makeUI());
      f.setSize(320, 240);
      f.setLocationRelativeTo(null);
      f.setVisible(true);
    });
  }
}