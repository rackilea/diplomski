public class BallsUp {

    public static void main(String[] args) {
        new BallsUp();
    }

    public BallsUp() {
        JFrame frame = new JFrame();
        frame.setTitle("Balls up");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);

        BallPane ballPane = new BallPane();
        JPanel mainPane = new JPanel(new BorderLayout());
        mainPane.add(ballPane);

        JPanel north = new JPanel(new GridBagLayout());
        north.add(new JButton(new BallPane.UpAction(ballPane)));
        mainPane.add(north, BorderLayout.NORTH);

        JPanel south = new JPanel(new GridBagLayout());
        south.add(new JButton(new BallPane.DownAction(ballPane)));
        mainPane.add(south, BorderLayout.SOUTH);

        JPanel east = new JPanel(new GridBagLayout());
        east.add(new JButton(new BallPane.RightAction(ballPane)));
        mainPane.add(east, BorderLayout.EAST);

        JPanel west = new JPanel(new GridBagLayout());
        west.add(new JButton(new BallPane.LeftAction(ballPane)));
        mainPane.add(west, BorderLayout.WEST);

        frame.add(mainPane);
        frame.setVisible(true);

    }

}