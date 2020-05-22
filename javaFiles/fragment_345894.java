public class Main extends JFrame {

    int x;
    int y;
    int z;

    public Main(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
        setTitle("Graph");

        setSize(1000, 1000);

        setVisible(true);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void paint(Graphics g) {

        g.fillOval(x, x + 20, 40, 40);

        g.drawLine(x + 10, x + 50, x + z + 10, z + 30);

        g.fillOval(x + z, z, 40, 40);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int x = scan.nextInt();
        int z = scan.nextInt();
        int y = scan.nextInt();
        x = x + 1;
        z = z + 1;
        y = y + 1;
        Main m = new Main(x, y, z);

    }
}