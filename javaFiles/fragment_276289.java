class MainMenu extends GameState{

    //declare font once
    private static final Font ARIAL_24 = new Font("Arial", Font.PLAIN, 24);

    private String[] options = {"New Game", "Load Game", "Options", "Exit"};
    private int currentSelection = 0;

    public MainMenu(GameStateManager gsm) {
        super(gsm);
    }
    public void init() {}

    public void tick() {

    }
    public void draw(Graphics g) {
        for(int i = 0; i < options.length; i++){
            //simple ternary operator can replace what was here before.
            g.setColor(i == currentSelection ? Color.GREEN : Color.BLACK);

            //since this never changes make it static and final
            //avoid recreating objects in a paint method, or when not neccesary
            g.setFont(ARIAL_24); 
            g.drawString(options[i], Game.WIDTH/2-50, 50 * i + 30);
        }
    }
    public void keyPressed(int k) {

    }
    public void keyReleased(int k) {

    }
}