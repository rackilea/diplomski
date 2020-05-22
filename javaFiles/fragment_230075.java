public class Interface extends JFrame {

public static void main(String[] args) {
    new Interface();
}

private CardLayout layout;
private JPanel manager;
private Introduction start;
private MainDisplay display;

public Interface() {
    super("Demo");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setMinimumSize(new Dimension(750, 500));
    this.setPreferredSize(new Dimension(750, 500));
    this.setMaximumSize(new Dimension(750, 500));

    setUp();

    this.pack();
    this.setVisible(true);
}

private void setUp() {
    layout = new CardLayout();
    manager = new JPanel(layout);
    this.add(manager);

    start = new Introduction();
    manager.add(start, INTRODUCTION);

    display = new MainDisplay();
    manager.add(display);

    layout.show(manager);
}

public class Introduction extends JPanel implements ActionListener {

    private static final int LOAD = 0;
    private static final int SAVE = 1;
    private JButton start;
    private JButton toGame;
    private JButton load;
    private JButton save;
    private JButton exit;

    public Introduction() {
        setUp();
    }

    private void setUp() {
        SpringLayout manager = new SpringLayout();
        this.setLayout(manager);

        JLabel title = new JLabel("Demo");
        title.setFont(new Font(Font.SERIF, Font.BOLD, 60));
        manager.putConstraint(SpringLayout.HORIZONTAL_CENTER, title, 0,
                SpringLayout.HORIZONTAL_CENTER, this);
        manager.putConstraint(SpringLayout.NORTH, title, 10, SpringLayout.NORTH,
                this);
        this.add(title);

        start = new JButton("New Game");
        start.setFont(new Font(Font.SERIF, Font.PLAIN, 16));
        start.addActionListener(this);
        manager.putConstraint(SpringLayout.HORIZONTAL_CENTER, start, -250,
                SpringLayout.HORIZONTAL_CENTER, this);
        manager.putConstraint(SpringLayout.NORTH, start, 50, SpringLayout.SOUTH,
                title);
        this.add(start);

        toGame = new JButton("Continue");
        toGame.setFont(new Font(Font.SERIF, Font.PLAIN, 16));
        toGame.addActionListener(this);
        toGame.setEnabled(false);
        manager.putConstraint(SpringLayout.HORIZONTAL_CENTER, toGame, -250,
                SpringLayout.HORIZONTAL_CENTER, this);
        manager.putConstraint(SpringLayout.NORTH, toGame, 10, SpringLayout.SOUTH,
                start);
        this.add(toGame);

        load = new JButton("Load Game");
        load.setFont(new Font(Font.SERIF, Font.PLAIN, 16));
        load.addActionListener(this);
        manager.putConstraint(SpringLayout.HORIZONTAL_CENTER, load, -250,
                SpringLayout.HORIZONTAL_CENTER, this);
        manager.putConstraint(SpringLayout.NORTH, load, 10, SpringLayout.SOUTH,
                toGame);
        this.add(load);

        save = new JButton("Save Game");
        save.setFont(new Font(Font.SERIF, Font.PLAIN, 16));
        save.addActionListener(this);
        save.setEnabled(false);
        manager.putConstraint(SpringLayout.HORIZONTAL_CENTER, save, -250,
                SpringLayout.HORIZONTAL_CENTER, this);
        manager.putConstraint(SpringLayout.NORTH, save, 10, SpringLayout.SOUTH, load);
        this.add(save);

        exit = new JButton("Exit Game");
        exit.setFont(new Font(Font.SERIF, Font.PLAIN, 16));
        exit.setToolTipText("Saves the current game, and exits the program.");
        exit.addActionListener(this);
        manager.putConstraint(SpringLayout.HORIZONTAL_CENTER, exit, -250,
                SpringLayout.HORIZONTAL_CENTER, this);
        manager.putConstraint(SpringLayout.NORTH, exit, 10, SpringLayout.SOUTH, save);
        this.add(exit);
    }

    private void perform(int option) {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(new TextFileFilter());
        if (option == LOAD) {
            int choice = chooser.showDialog(this, "Load Game");
            if (choice == JFileChooser.APPROVE_OPTION)
                chooser.getSelectedFile();
        } else if (option == SAVE) {
            int choice = chooser.showDialog(this, "Save Game");
            if (choice == JFileChooser.APPROVE_OPTION)
                chooser.getSelectedFile();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (display.isRunning()) {
            if (e.getSource() == start || e.getSource() == load) {
                String verify = "A game is currently running.  Are you sure you want to start a new game?"
                        + "\r\nAny previous game data will be deleted.";
                int choice = JOptionPane.showConfirmDialog(this, verify,
                        "New Game - Warning", JOptionPane.YES_NO_OPTION,
                        JOptionPane.WARNING_MESSAGE);

                if (choice == JOptionPane.NO_OPTION)
                    return;
            }
        }

        if (e.getSource() == start) {
            display.start();
            layout.show(manager, MAIN_DISPLAY);
            toGame.setEnabled(true);
            save.setEnabled(true);
        } else if (e.getSource() == toGame)
            layout.show(manager, MAIN_DISPLAY);
        else if (e.getSource() == load)
            perform(LOAD);
        else if (e.getSource() == save)
            perform(SAVE);
        else if (e.getSource() == exit) {
            perform(SAVE);
            Interface.this.setVisible(false);
            Interface.this.dispose();
        }
    }

}

public class MainDisplay extends JPanel implements ActionListener {

    private static final long serialVersionUID = 1L;
    private boolean running;
    private JButton overview;
    private JButton map;
    private JButton ranking;
    private JButton reports;
    private JButton home;

    public MainDisplay() {
        running = false;
        setUp();
    }

    public boolean isRunning() {
        return running;
    }

    private void setUp() {
        SpringLayout manager = new SpringLayout();
        this.setLayout(manager);

        ranking = new JButton("Ranking");
        ranking.setFont(new Font(Font.SERIF, Font.PLAIN, 10));
        ranking.addActionListener(this);
        manager.putConstraint(SpringLayout.HORIZONTAL_CENTER, ranking, 0,
                SpringLayout.HORIZONTAL_CENTER, this);
        manager.putConstraint(SpringLayout.NORTH, ranking, 10, SpringLayout.NORTH,
                this);
        this.add(ranking);

        map = new JButton("Map");
        map.setFont(new Font(Font.SERIF, Font.PLAIN, 10));
        map.addActionListener(this);
        manager.putConstraint(SpringLayout.EAST, map, -10, SpringLayout.WEST,
                ranking);
        manager.putConstraint(SpringLayout.NORTH, map, 10, SpringLayout.NORTH, this);
        this.add(map);

        overview = new JButton("Overview");
        overview.setFont(new Font(Font.SERIF, Font.PLAIN, 10));
        overview.addActionListener(this);
        manager.putConstraint(SpringLayout.EAST, overview, -10, SpringLayout.WEST,
                map);
        manager.putConstraint(SpringLayout.NORTH, overview, 10, SpringLayout.NORTH,
                this);
        this.add(overview);

        reports = new JButton("Reports");
        reports.setFont(new Font(Font.SERIF, Font.PLAIN, 10));
        reports.addActionListener(this);
        manager.putConstraint(SpringLayout.WEST, reports, 10, SpringLayout.EAST,
                ranking);
        manager.putConstraint(SpringLayout.NORTH, reports, 10, SpringLayout.NORTH,
                this);
        this.add(reports);

        home = new JButton("Home");
        home.setFont(new Font(Font.SERIF, Font.PLAIN, 10));
        home.addActionListener(this);
        manager.putConstraint(SpringLayout.WEST, home, 10, SpringLayout.EAST,
                reports);
        manager.putConstraint(SpringLayout.NORTH, home, 10, SpringLayout.NORTH, this);
        this.add(home);
    }

    public void start() {
        running = true;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == home) {
            layout.show(manager, INTRODUCTION);
        }
    }

}

public static final class TextFileFilter extends FileFilter {

    private static final String FILE_EXTENSION = "tra";

    @Override
    public boolean accept(File f) {
        if (f.isDirectory())
            return true;
        if (f.getName().toLowerCase().endsWith(FILE_EXTENSION))
            return true;
        return false;
    }

    @Override
    public String getDescription() {
        return "Demo";
    }
}

}