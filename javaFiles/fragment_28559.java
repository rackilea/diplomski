import java.awt.EventQueue;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

public class TestCardLayout {

    public static void main(String[] args) {
        new TestCardLayout();
    }

    public TestCardLayout() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                Random rnd = new Random();
                DefaultTableModel model = new DefaultTableModel(new Object[]{"Check boxes"}, 0) {

                    @Override
                    public Class<?> getColumnClass(int columnIndex) {
                        return Boolean.class;
                    }

                };
                for (int index = 0; index < 10; index++) {
                    model.addRow(new Object[]{rnd.nextBoolean()});
                }
                JTable table = new JTable(model);

                final JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new JScrollPane(table));
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

}