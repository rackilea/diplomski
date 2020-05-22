public class Foo {

    public static void main(String[] args) {
        JFrame frame = new JFrame("TicketGenie");
        frame.setContentPane(new TicketGenie().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}