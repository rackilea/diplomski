public class Board extends JFrame implements MouseListener,ActionListener {
    public int x1, y1, x2, y2;

    public Board() {
       setSize(1200, 800);
       Container con = getContentPane();
       con.setBackground(Color.RED);
       addMouseListener(this);
       setVisible(true);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       ...