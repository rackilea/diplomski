public class Test extends JFrame {

    static String data = "<html>Text color: <font color='red'>red</font></html>";
    static int size = 4;

    public Test() {

        JTable table = new JTable(size, size);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                table.getModel().setValueAt(data, i, j);
            }
        }
        add(table);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {

        new Test();
    }
}