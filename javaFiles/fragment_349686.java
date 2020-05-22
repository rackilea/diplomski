import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;

public class Virus extends JFrame{
    private static final long serialVersionUID =1L;
    JFrame jf = new JFrame("Virus");
    static JPanel thegame = new JPanel(new CardLayout());
    JPanel game = new VirusGamePanel();
    JPanel start = new StartScreen();

    public Virus(){
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setResizable(false);                               
        thegame.add(start);
        thegame.add(game);
        jf.add(thegame);        
        jf.pack();
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);
    }

    public static void main(String[] args) {
        new Virus();

    }

}

class StartScreen extends JPanel implements ActionListener{
    private static final long serialVersionUID = 1L;
    JButton start = new JButton("Start");
    public StartScreen(){
        start.addActionListener(this);
        start.setBounds(new Rectangle(400,300,100,30));
        this.add(start);
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setFont(new Font("Impact",Font.BOLD,72));
        g.setColor(Color.MAGENTA);
        g.drawString("Virus",275,300);
    }

    @Override
    public Dimension getPreferredSize()
    {
        return (new Dimension(600, 600));
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==start)
        {
            //what to do here?
            CardLayout cardLayout = (CardLayout) Virus.thegame.getLayout();
            cardLayout.next(Virus.thegame);
        }
    }
}

class VirusGamePanel extends JPanel
{
    public VirusGamePanel()
    {
        JLabel label = new JLabel("I am ON", JLabel.CENTER);
        add(label);
    }

    @Override
    public Dimension getPreferredSize()
    {
        return (new Dimension(600, 600));
    }
}