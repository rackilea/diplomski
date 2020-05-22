class View {

    private final BallsPane ballsPane;

    View(Model model){
        ballsPane = new BallsPane(model);
    }

    void createAndShowGui(){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.add(ballsPane);
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
    }

    Observer getObserver(){
        return ballsPane;
    }
}

class BallsPane extends JPanel implements Observer {

    private final Model model;

    BallsPane(Model model){
        this.model = model;
        setPreferredSize(new Dimension(model.getWidth(), model.getHeight()));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(Ball b : model.getBalls()){
            g.setColor(b.getColor());
            g.fillOval(b.getX(), b.getY(), b.getSize(), b.getSize());
        }
    }

    @Override
    public void onObservableChanged() {
        repaint(); //when a change was notified
    }
}