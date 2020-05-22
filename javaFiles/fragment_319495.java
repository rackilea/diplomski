public class GameOfLife extends JFrame {
    private static final long serialVersionUID = 1L;
    private Thread thread;
    private SimulationThread simulationThread;

    public GameOfLife() {
        super("GameOfLife");
    }


    class MyPanel extends JPanel {
        private static final long serialVersionUID = 1L;

        public MyPanel() {
            setBorder(BorderFactory.createLineBorder(Color.black));
        }

        public Dimension getPreferredSize() {
            return new Dimension(1000, 1000);
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);       
            Graphics2D g2d = (Graphics2D)  g;
            simulationThread.drawScreenItems(g2d);
        }
    }
    /**
     * Create the GUI and show it. For thread safety, this method should be invoked
     * from the event-dispatching thread.
     */
    public void createAndShowGUI() {
        // Schedule a job for the event-dispatching thread:
        // creating and showing this application's GUI.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MyPanel myPanel = new MyPanel();
        add(myPanel);

        // Display the window.
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        // Create and set up the window.

        // create thread with genetic reproduction callback code.
        simulationThread = new SimulationThread(myPanel);
        thread = new Thread(simulationThread);
        thread.start();
    }

    public static void main(String[] args) {
        final GameOfLife swingGa = new GameOfLife();
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                swingGa.createAndShowGUI();
            }
        });
    }
}

public class SimulationThread implements Runnable {
    private MyPanel myPanel;
    public boolean run = true;
    static final int GAME_SIZE = 200;

    boolean[][] cells;
    boolean[][] newCells;

    public SimulationThread(MyPanel myPanel) {
        this.myPanel = myPanel;
        cells = new boolean[GAME_SIZE][GAME_SIZE];
        for (int i = 1; i < cells.length - 1; i++) {
            for (int j = 1; j < cells[0].length - 1; j++) {
                cells[i][j] = Math.random() > 0.5;
            }
        }
        newCells = new boolean[GAME_SIZE][GAME_SIZE];
    }

    @Override
    public void run() {
        while (run) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            // Iterate through the array, follow game of life rules
            for (int i = 1; i < cells.length - 1; i++) {
                for (int j = 1; j < cells[0].length - 1; j++) {
                    int surrounding = 0;
                    if (cells[i - 1][j - 1]) surrounding++;
                    if (cells[i - 1][j]) surrounding++;
                    if (cells[i - 1][j + 1]) surrounding++;
                    if (cells[i][j - 1]) surrounding++;
                    if (cells[i][j + 1]) surrounding++;
                    if (cells[i + 1][j - 1]) surrounding++;
                    if (cells[i + 1][j]) surrounding++;
                    if (cells[i + 1][j + 1]) surrounding++;
                    newCells[i][j] = false;
                    if (cells[i][j]) {
                        // Cell is alive, Can the cell live? (2-3)
                        if ((surrounding == 2) || (surrounding == 3)) {
                            newCells[i][j] = true;
                        }
                    } else {
                        // Cell is dead, will the cell be given birth? (3)
                        if (surrounding == 3) {
                            newCells[i][j] = true;
                        }
                    }
                }
            }
            synchronized(cells) {
                for (int i = 1; i < cells.length - 1; i++) {
                    for (int j = 1; j < cells[0].length - 1; j++) {
                        cells[i][j] = newCells[i][j];
                    }
                }
            }
            myPanel.repaint();
        }

    }

    public void drawScreenItems(Graphics2D g2d) {
        synchronized(cells) {
            for (int i = 1; i < cells.length - 1; i++) {
                for (int j = 1; j < cells[0].length - 1; j++) {
                    if (cells[i][j])
                        g2d.fillRect(i * (1000 / GAME_SIZE), j * (1000 / GAME_SIZE), 1000 / GAME_SIZE, 1000 / GAME_SIZE);
                }
            }
        }
    }
}