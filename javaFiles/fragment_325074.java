public class Four extends JFrame implements ActionListener {

    private final int SIZE = 180;
    Color colors[] = {Color.RED, Color.ORANGE, Color.YELLOW, 
          Color.GREEN, Color.BLUE, Color.CYAN};
    int i = 0;
    private Container con = getContentPane();
    private JButton button = new JButton("Press Me");

    public Four() {
        super("Frame");
        setSize(SIZE, SIZE);
        con.setLayout(new FlowLayout());
        con.add(button);
        button.addActionListener(this);
    }

    public void actionPerformed(ActionEvent event) {
        con.setBackground(colors[i++ % colors.length]);
    }

    public static void main(String[] args) {
        Four frame = new Four();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}