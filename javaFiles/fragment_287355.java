public class JListTest {


public static void main(String[] args) {

    DefaultListModel<String> model = new DefaultListModel<>();
    model.addElement("item1");
    model.addElement("item2");
    model.addElement("item3");
    final JList<String> list = new JList<String>(model);

    JButton open = new JButton("open");
    open.addActionListener(new ActionListener()

    {
        public void actionPerformed(ActionEvent e) {
            DefaultListModel<String> model = (DefaultListModel<String>) list.getModel();
            model.removeAllElements();
        }
    });
    JFrame frame = new JFrame();
    frame.setSize(400, 400);
    Container con = frame.getContentPane();
    con.setLayout(new BorderLayout());

    con.add(open, BorderLayout.LINE_START);
    con.add(list, BorderLayout.CENTER);
    con.add(new JScrollPane(list));
    frame.setVisible(true);

}