import javax.swing.*;
    import java.awt.*;
    import java.awt.event.KeyEvent;
    import java.awt.event.KeyListener;
    import java.util.Timer;
    import java.util.TimerTask;

    public class Main {
        

        public static void main(String[] args) {



            JFrame frame = new JFrame("gEngine");

            Player[] players = new Player[]{
                    new Player(100),
                    new Player(1000)
            };
            frame.add(new PongWindow(players));


            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setBackground(Color.RED);
            frame.setSize(1280, 720);
            frame.setResizable(false);
            frame.setVisible(true);




        }


        static class Player{
            int x;
            int y;

            Player(int x){this.x=x;}

            void moveUp(){y+= -8;}
            void moveDown(){y+= 8;}

            void drawPlayer(Graphics2D g){
                g.fillRect(x,y,40,120);
            }

        }


        static class PongWindow extends JPanel {

            //private JPanel panel = new JPanel();
            Player[] players;

            PongWindow(Player[] players) {
                this.players = players;
                setBackground(Color.BLACK);

                new Timer().scheduleAtFixedRate(new TimerTask() {
                    @Override
                    public void run() {
                        repaint();
                        players[0].moveDown();
                    }
                }, 300, 1000 / 60);


            }



            @Override
            public void paint(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.WHITE);

                for(Player p : players){
                    p.drawPlayer((Graphics2D) g);
                }
            }
        }

    }