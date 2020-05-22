public class CardLayoutGameController implements GameController {
    public static final String GAME_PANEL = "GamePanel";
    public static final String MENU_PANEL = "MenuPanel";

    private Container container;
    private CardLayout cardLayout;

    public CardLayoutGameController(Container parent, CardLayout layout) {
        container = parent;
        cardLayout = layout;
    }

    public void showMenu() {
        cardLayout.show(container, MENU_PANEL);
    }

    public void showGame() {
        cardLayout.show(container, GAME_PANEL);
    }
}