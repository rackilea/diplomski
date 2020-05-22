public class Board extends JFrame implements MouseListener,ActionListener {
    public int x1, y1, x2, y2;

    public Board() {
    JFrame frame = new JFrame();
    frame.setSize(1200, 800);
    Container con = frame.getContentPane();
    con.setBackground(Color.RED);
    addMouseListener(this);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    ...