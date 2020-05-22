public class Test 
{
    public static void main(String[] args) 
    {
        JFrame jframe = new JFrame();
        GamePanel gp = new GamePanel();

        jframe.setContentPane(gp);
        jframe.setVisible(true);
        jframe.setSize(500,500);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }


    public static class GamePanel extends JPanel{

    GamePanel() {
        JButton buttonShip1 = new JButton("Button number 1");
        JButton buttonShip2 = new JButton("Button number 2");
        add(buttonShip1);
        add(buttonShip2);

        //setLayout(null);
        //if you don't use a layout manager and don't set it to null
        //it will automatically set it to a FlowLayout.
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        // ... add stuff here later
            // when you've read more about Swing and
            // painting in Swing applications

        }
    }

}