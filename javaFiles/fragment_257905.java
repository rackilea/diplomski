public class JavaGame2 extends JFrame {

    public JavaGame2(){
        CardLayout layout = new CardLayout();
        setLayout(layout);
        GameController controller = new CardLayoutGameController(getContentPane(), layout);

        gamePanel = new GamePanel(controller);          
        menuPanel = new MenuPanel(controller);

        add(gamePanel, CardLayoutGameController.GAME_PANEL);
        add(menuPanel, CardLayoutGameController.MENU_PANEL);

        controller.showMenu();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setTitle("JavaGame2");
        setResizable(false);    
    }
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame jgame = new JavaGame2();
                jgame.setVisible(true);
            }
        });
    }
}