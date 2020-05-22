public class MyFrame extends JFrame implements ActionListener{
    //static variables
    private JButton buttons[] = new JButton[N];
    private int counter = 0;
    private int clickedX, clickedY;

    public static void main (String[] args) {
        new MyFrame();
    }

    public MyFrame(){
        for (int i = 0; i < buttons.length; i++)
        {
            JButton b = new JButton();
            b.addActionListener(this);
            buttons[i] = b;
        }
        // Doing Everything Here
        setSize(300, 380);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        // Layout, JMenu etc.
    }

    public void actionPerformed (ActionEvent e) {
        // your code
    }
}