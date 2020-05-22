import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class NamesInterface extends JFrame{

    JTextField player1Text; 
    JTextField player2Text;
    Player player1;
    Player player2;
    JButton startButton;

    public NamesInterface(){

        super();
        setSize(500, 1000);
        setLayout(new BorderLayout());

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel inputWindow = new JPanel();

        inputWindow.setSize(500, 200);
        inputWindow.setLayout(new GridLayout(3, 1));

        inputWindow.add(new JLabel("Enter Player 1 name:"));
        JTextField player1Text = new JTextField();
        player1Text.setSize(400, 400);
        inputWindow.add(player1Text);

        inputWindow.add(new JLabel("Enter Player 2 name:"));
        JTextField player2Text = new JTextField();
        player2Text.setSize(400, 400);
        inputWindow.add(player2Text);

        startButton  = new JButton("Start");
        startButton.setSize(500, 500);
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                System.out.println(player1Text.getText());
                System.out.println(player2Text.getText());
            }
        });
        inputWindow.add(startButton);

        this.add(inputWindow, BorderLayout.CENTER);
        setVisible(true);
    }
}