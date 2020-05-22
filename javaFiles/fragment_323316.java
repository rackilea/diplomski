import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Test extends JFrame {

    public static void main(String[] args) throws Exception {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new Test().createAndShowUI();
            }
        });

    }

    private void createAndShowUI() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents(frame);
        frame.pack();
        frame.setVisible(true);
        new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    Thread.sleep(2500);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
                } 
                SwingUtilities.invokeLater(new Runnable() {

                     @Override
                     public void run() {
                       model.setValueAt("hello", 0, 0);
                     }
                });
            }
        }).start();
    }
    static DefaultTableModel model;

    private void initComponents(JFrame frame) {

        String data[][] = {
            {"1", "2", "3"},
            {"4", "5", "6"},
            {"7", "8", "9"},
            {"10", "11", "12"}
        };

        String col[] = {"Col 1", "Col 2", "Col 3"};

        model = new DefaultTableModel(data, col);
        JTable table = new JTable(model);

        frame.getContentPane().add(new JScrollPane(table));
    }
}