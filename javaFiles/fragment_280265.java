import javax.swing.*;
public class SorterChooser {
    private static void createAndShowGUI() {
        JFrame frame = new JFrame("SorterChooser");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Object[][] data = { {"a", "1"}, {"b", "3"}, {"c", "2"}, {"d", "4"} };
        String[] colnames = { "c1", "c2" };
        JTable tab = new JTable(data, colnames);
        tab.getTableHeader().setUI(new SorterChooserTableHeaderUI());  // new code
        JScrollPane sp = new JScrollPane(tab);

        tab.setAutoCreateRowSorter(true);
        new TableColumnManager(tab, true);

        frame.getContentPane().add(sp);
        frame.pack();
        frame.setVisible(true);
    }
    public static void main (String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}