import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MakeFrame extends JFrame implements ActionListener{


JPanel buttonPanel;
JButton solve1;
JButton solve2;
JButton solve3;
JButton clear;
JButton reset;

Maze maze;

public MakeFrame(){
    super("Maze");
    init();
}

public void init() {
     //makes a frame, names it maze
    maze = new Maze();
    super.getContentPane().add(maze, BorderLayout.CENTER);

    buttonPanel = new JPanel();
    super.getContentPane().add(buttonPanel, BorderLayout.NORTH);
    solve1 = new JButton("solve 1"); // create some buttons
    solve2 = new JButton("solve 2");
    solve3 = new JButton("solve 3");
    clear = new JButton("clear");
    reset = new JButton("reset");

    buttonPanel.add(solve1); // add the buttons to a panel
    buttonPanel.add(solve2);
    buttonPanel.add(solve3);
    buttonPanel.add(clear);
    buttonPanel.add(reset);

    solve1.addActionListener(this);// assigns action listeners to buttons
    solve2.addActionListener(this);
    solve3.addActionListener(this);
    clear.addActionListener(this);
    reset.addActionListener(this);

    super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    // makes the frame visable, grey and close on exit.
    super.setSize(455, 320);
    super.setVisible(true);
    super.setBackground(Color.GRAY);

}

public void repaint(){
    init();
}

public void actionPerformed(ActionEvent e) {
    if (e.getSource() == reset) {
        super.getContentPane().removeAll();
        repaint();
    }
}
}