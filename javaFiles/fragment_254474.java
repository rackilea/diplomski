import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TestResize {

    private JFrame stage;
    private Container CurrentMenu;
    private boolean isRunning = true; //used to state whether game is running

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TestResize();
            }
        });
    }

    public TestResize() {
        CurrentMenu = new Container(this, stage);     // swap GameMenu with GameContainer to be able to see difference with painting
        stage = new JFrame("Touhou FBE");//creates game window
        stage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//sets up default handler for closing window
        stage.add(CurrentMenu);
        stage.setResizable(false);
        stage.pack();
        stage.setVisible(true);//sets frame to visible
        // This needs to be started in a separate thread
//        test.Game_loop();
    }

    public void Game_loop() {
//        while (isRunning) {
//            test.repaint();
//        }
    }

    public class Container extends JPanel {

        public TestResize Game;
        public JFrame stage;
        private Image img;

        public Container(TestResize game, JFrame Stage) {
            Game = game;
            stage = Stage;
            img = (new ImageIcon("resources/background.png").getImage());
        }

        @Override
        public Dimension getPreferredSize() {
            Dimension size = img == null ? new Dimension(700, 400) : new Dimension(img.getWidth(this), img.getHeight(this));
            return size;
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(img, 0, 0, this);
            g.setColor(Color.RED);
            g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);            
        }
    }
}