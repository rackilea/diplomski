public class Gui extends JFrame {
    private JComboBox<String> box;
    private JLabel picture;
    private static String[] filename = {"C:\\Users\\..\\pic1.jpg","C\\Users\\..\\pic2.jpg" };
    private Icon[] pics = { new ImageIcon(filename[0]),
        new ImageIcon(filename[1] ) };

Gui() {
    super("window");
    setLayout(new FlowLayout());
    setVisible(true);
    setSize(600, 500);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    box = new JComboBox<String>(filename);
    box.addItemListener(new ItemListener() {
        public void itemStateChanged(ItemEvent e) {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                picture.setIcon(pics[box.getSelectedIndex()]);
            }
        }
    });
    picture = new JLabel(pics[0]);
    add(picture);
    add(box);
}

public static void main(String[] args){
    Gui t = new Gui();
    t.setVisible(true);
}