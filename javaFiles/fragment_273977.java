public class Class  extends JFrame {
    public Class () {
        super("Title");

        getContentPane().setLayout(
                new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        setResizable(false);

        JTextArea window1 = new JTextArea("text");
        window1.setEditable(false);
        window1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        window1.setLineWrap(true);


        JScrollPane scroll1 = new JScrollPane(window1);
        scroll1.setPreferredSize(new Dimension(200, 250));
        scroll1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scroll1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        add(scroll1);

        JTextArea window2 = new JTextArea();
        window2.setEditable(true);
        window2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        window2.setLineWrap(true);
        add(window2);

        JScrollPane scroll2 = new JScrollPane(window2);
        scroll2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scroll2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroll2.setPreferredSize(new Dimension(100, 50));
        add(scroll2);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    public static void main(String... s){
        new Class();
    }
}