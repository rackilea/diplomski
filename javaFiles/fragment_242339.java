public class GamePanel {

    private JPanel GamePanel = new JPanel();

    public JPanel getGamePanel() {
        return GamePanel;
    }

    public void setGamePanel(JPanel GamePanel) {
        this.GamePanel = GamePanel;
    }

    public GamePanel() {
        GamePanel.setBackground(Color.green);
    }

}