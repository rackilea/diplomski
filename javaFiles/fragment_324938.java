import java.awt.Color;
import java.awt.Dimension;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class MenuExample
{
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                JPanel mainMenuPanel = new MainMenuPanel();
                createAndShowFrame(mainMenuPanel);
            }
        });
    }

    static void createAndShowFrame(JPanel panel)
    {
        JFrame frame = new JFrame();
        frame.getContentPane().add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(800, 600));
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    static JButton createNextParticipantButton(
        final JComponent container, final int nextID)
    {
        JButton nextParticipantButton = new JButton("New Participant");
        nextParticipantButton.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                Window window = 
                    SwingUtilities.getWindowAncestor(container);
                window.dispose();

                ParticipantPanel participantPanel = 
                    new ParticipantPanel(nextID);
                createAndShowFrame(participantPanel);
            }
        });
        return nextParticipantButton;
    }

}

class MainMenuPanel extends JPanel
{
    public MainMenuPanel() 
    {
        setBackground(Color.BLUE);
        add(MenuExample.createNextParticipantButton(this, 0));
    }
}

class ParticipantPanel extends JPanel
{
    private final int participantID;

    public ParticipantPanel(int participantID) 
    {
        this.participantID = participantID;

        add(new JLabel("Add the contents for participant "+participantID));
        add(MenuExample.createNextParticipantButton(this, participantID+1));
    }
}