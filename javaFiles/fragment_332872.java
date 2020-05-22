import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class QuestionAnswerPanel extends JPanel{

    private Image background;
    //use publicly available resources when posting questions or answers
    private final String imageLink = "https://www.whatsonnetwork.co.uk/uploads/800x600/98331337cb0f7f31c874e22a8f2b5f8b.jpg";

    QuestionAnswerPanel() {

        URL url;
        try {
            url = new URL(imageLink);
            background = ImageIO.read(url);
            setPreferredSize(new Dimension(background.getWidth(null), background.getHeight(null)));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        //border layout  allows you to add components to 5 positions,
        //including north and center
        setLayout(new BorderLayout());

        //have a JPanel for the question
        JLabel lab = new JLabel("To Be Or Not To Be ?");
        lab.setFont(new Font("Helvetica", Font.BOLD, 40));
        lab.setForeground(new Color(189, 189, 189, 255));
        JPanel questionPanel = new JPanel();
        questionPanel.setOpaque(false);
        questionPanel.add(lab);
        add(questionPanel, BorderLayout.NORTH); //place it at the top

        //have a JPanel for the answer
        JPanel answerPanel = new JPanel();
        answerPanel.setOpaque(false);
        //use GridBagLayout to center components
        answerPanel.setLayout(new GridBagLayout());
        //add components as you need
        answerPanel.add(new JButton("Yes"));
        answerPanel.add(new JButton("No"));
        add(answerPanel, BorderLayout.CENTER);//place it at the center
    }


    @Override //Override to paint image at the background
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, null);
    }

    public static void main(String[] args) throws IOException {
        JFrame frame=new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new QuestionAnswerPanel());
        frame.pack();
        frame.setVisible(true);
    }
}