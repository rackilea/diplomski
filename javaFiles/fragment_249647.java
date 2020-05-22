import javax.swing.*;
import java.awt.*;
import java.util.List;
public class Project1GUI
{
    JTextArea unsorted_words, sorted_words, linked_words;

    public Project1GUI()
    {
        JFrame frame = new JFrame("Title");
        JPanel panel = new JPanel(new GridLayout(2, 1));

        unsorted_words = new JTextArea();
        sorted_words = new JTextArea();
        linked_words = new JTextArea();

        panel.add(unsorted_words);
        panel.add(sorted_words);
        panel.add(linked_words);

        frame.add(panel);
        frame.setSize(400,400);
        frame.setLocation(200,200);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}