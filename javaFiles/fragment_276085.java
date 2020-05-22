public class MyTest extends JFrame {

    public static void main(String[] args) {
        MyTest test = new MyTest();
        test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        test.setSize(300, 200);
        test.setVisible(true);
    }

    public MyTest() {
        String[] data = {
            "Arlo", "Cosmo", "Elmo", "Hugo",
            "Jethro", "Laszlo", "Milo", "Nemo",
            "Otto", "Ringo", "Rocco", "Rollo"
        };
        JList list = new JList(data);
        list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        list.setVisibleRowCount(0);
        JScrollPane scroll = new JScrollPane(list);
        this.add(scroll);
    }
}