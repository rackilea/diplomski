public class Result extends JFrame {

    public Result(){
        getContentPane().setBackground(Color.white);
        initComponents();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        add(panel);
        JLabel im = new JLabel(new ImageIcon("right.jpg"));
        panel.add(im);
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Result tmp = new Result();
                tmp.setSize(600, 600);
                tmp.setVisible(true);
            }
        });
    }
}