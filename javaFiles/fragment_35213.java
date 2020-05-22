import java.awt.Component;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                String text
                                = "<html><div align=center>"
                                + "And Caesar's spirit, raging for revenge,<br>"
                                + "With Ate by his side come hot from hell,<br>"
                                + "Shall in these confines with a monarch's voice<br>"
                                + "Cry \"Havoc!\" and let slip the dogs of war,<br>"
                                + "That this foul deed shall smell above the earth<br>"
                                + "With carrion men, groaning for burial.";

                DefaultTableModel model = new DefaultTableModel(0, 1);
                model.addRow(new String[]{text});

                JTable table = new JTable(model) {
                    @Override
                    public int getRowHeight(int row) {
                        Component comp = prepareRenderer(getCellRenderer(row, 0), row, 0);
                        return comp.getPreferredSize().height;
                    }
                };
                ((JLabel)table.getDefaultRenderer(Object.class)).setHorizontalAlignment(JLabel.CENTER);
                ((JLabel)table.getDefaultRenderer(Object.class)).setVerticalAlignment(JLabel.CENTER);
                table.setRowHeight(100);

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new JScrollPane(table));
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

}