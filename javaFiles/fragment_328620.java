class Window extends JFrame {

        public String myStr = "";
        private MyPanel myPane;

        public static void main(String [] args) {
            Window mainWindow = new Window();
}

public Window() {
    this.myPane = new MyPanel();
        getContentPane().add(myPane);

    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setSize(300, 600);
    this.setVisible(true);
}

    public computations() {
// Here I would like to get myPane.s, or do other things regarding myPane's attributes (with getters), only once myPane.b2 is pressed.
     System.out.println(this.myStr);
    }
}

class MyPanel extends JPanel {
Window win = null;
String s;
JButton b1;
JButton b2;

public MyPanel(Window window) {
    this.win = window;
    s = new String("");
    b1 = new JButton("say hello");
    b2 = new JButton("Close");
    this.add(b1);
    this.add(b2);
    ButtonHandler phandler = new ButtonHandler();
    b1.addActionListener(phandler);
    b2.addActionListener( actionPerformed(ActionEvent e) {
        this.s = "Hello world";
    });

}


class ButtonHandler implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        // Tells Window class something happened.
        this.win.myStr = s;
    }
}