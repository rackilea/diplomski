public class Test extends JFrame{

    public static int width = 350;
    public static int height  = 480;

    public static void main (String args[]) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(width, height);

        window.setTitle("Virtual World");
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        window.getContentPane().setBackground(new Color(80,80,240));

        JButton enter = new JButton("Ok");
        enter.setVisible(true);
        JPanel panel = new JPanel();
        window.add(panel);
        panel.add(enter);
        window.setVisible(true);

    }

}