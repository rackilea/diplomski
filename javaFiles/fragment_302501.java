import javax.swing.*;

public class WellFitList {

    WellFitList() {
        initUI();
    }

    public void initUI() {
        String[] data = {"Data 1", "Data 2", "Data 3", "Data 4"};
        JList list = new JList(data);
        list.setVisibleRowCount(data.length);

        JOptionPane.showMessageDialog(null, new JScrollPane(list));
    }

    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                WellFitList o = new WellFitList();
            }
        };
        SwingUtilities.invokeLater(r);
    }
}