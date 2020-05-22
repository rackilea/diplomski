package studyfast;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Scratch 
{
    JFrame projectFrame = new JFrame();
    JPanel panelEditCard = new JPanel();
    JButton addCard = new JButton();
    JButton deleteCard = new JButton();

    public Scratch()
    {
        projectFrame.setSize(1000, 600);
        projectFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);   

        panelEditCard.add(addCard);
        panelEditCard.add(deleteCard);

        projectFrame.add(panelEditCard);
        projectFrame.setVisible(true);
      }

   public static void main(String[] args) 
   {
       new Scratch();
   }
}