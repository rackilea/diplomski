public class GameGUI extends JPanel implements ActionListener {

    public Button drawCard = new Button("Draw Card");
    public Image cheetah = null;

    public void createGui(JFrame p) {

        drawCard.addActionListener(this);
        drawCard.setBounds(20,30,80,30);
        p.add(drawCard);
    }

    @Override
    public void actionPerformed(ActionEvent event) {

        Object cause = event.getSource();

        if (cause == drawCard) {
        System.out.println("Ay");
        }
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);