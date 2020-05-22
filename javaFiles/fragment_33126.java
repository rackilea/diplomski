public class Control extends JFrame implements ActionListener {
    javax.swing.Timer timer;
    Button auto;
    public Control () {
        timer = new javax.swing.Timer (100, this);
        auto = new Button("Auto");
        auto.addActionListener(this);
        this.add(auto);
        this.setVisible(true);
        this.setBounds(100,100,100,100);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Control();
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == timer) {
            System.out.println("Timer finished!");
            return;
        }
        if (e.getActionCommand().equals("Auto")) {
            this.timer.start();
            auto.setLabel("Pause");
        }
        if (e.getActionCommand().equals("Pause")) {
            this.timer.stop();
            auto.setLabel ("Auto");
        }
    }
}