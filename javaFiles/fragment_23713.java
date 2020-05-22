public class GameWindow extends JFrame implements ActionListener {

    public GameWindow(){
        super("Game Window");

        setSize(1500, 800);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel tryThis = new JPanel();
        tryThis.setLayout(new BorderLayout());

        add(tryThis, BorderLayout.CENTER);

        JPanel grid1 = new JPanel();
        tryThis.add(grid1);

        int e = 4;
        int f = 14;
        JPanel[][] grid = new JPanel[e][f];
        grid1.setLayout(new GridLayout(e,f));

        for(int g = 0; g < e; g++) {
           for(int h = 0; h < f; h++) {
              grid[g][h] = new JPanel();
              grid1.add(grid[g][h]);
              grid[g][h].setBorder(BorderFactory.createTitledBorder("Info"));
           }
        }

        try {
            // Loads the image
            BufferedImage myPicture = ImageIO.read(MainClassNameGoesHere.class.getResource("/example.png"));
            JLabel picLabel = new JLabel(new ImageIcon(myPicture));

            // Displays the image
            grid[3][3].add(picLabel);
        } catch (IOException exception) {
            exception.printStackTrace();
        }

    }