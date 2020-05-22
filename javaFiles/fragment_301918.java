public class GUI {
    public static void Configuration(){
        JFrame frame = new JFrame("Figures Animation");
        frame.setSize(600,300);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new Paint(); // *** new Paint is here, but nothing is added
        frame.getContentPane().add(BorderLayout.CENTER, panel);
    }