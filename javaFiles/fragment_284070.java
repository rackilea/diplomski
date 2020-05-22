public class GamePanel {

    public GamePanel(GamePanel Parent, WelcomePanel Sister) {
        this.parent = Parent; // Parent JFrame
        this.sister = Sister; // Sister JPanel that works with this JPanel

        this.parent.addKeyListener(this); // do this