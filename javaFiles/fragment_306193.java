public class GamePanel extends JPanel {
    Player player;
    Rabbit rabbit;
    public void setPlayer(Player player) {
        this.player = player;
    }
    public void setRabbit(Rabbit rabbit) {
        this.rabbit = rabbit;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        player.paint(g);
        rabbit.paint(g);
    }
}