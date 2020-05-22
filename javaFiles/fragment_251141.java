/**
 *
 * @author Craig and me :D
 */
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.Border;

public class menu extends JPanel {

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI()
    {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().add(new menu(4,4));
        f.setLocationRelativeTo(null);
        f.pack();
        f.setVisible(true);
    }

    JButton[][] grid;
    TextField text = new TextField(20);

    public menu(int width, int length) {


        Border playerBorder = BorderFactory.createTitledBorder("Player");
        Border comBorder = BorderFactory.createTitledBorder("Com");


        JPanel player = new JPanel();
        player.setBorder(playerBorder);// set border round player grid 
        player.setLayout(new GridLayout(4,4));

        grid=new JButton[width][length]; //allocate the size of grid
        for(int y=0; y<length; y++){
            for(int x=0; x<width; x++){
                grid[x][y]=new JButton(); //creates new button    
                player.add(grid[x][y]); //adds button to grid
                grid[x][y].setBackground(Color.BLUE);//sets grid background colour
                grid[x][y].setPreferredSize(new Dimension(40, 40));//sets each grid buttons dimensions
                add(text);
                grid[x][y].addActionListener(
                    createActionListener(x, y, "Player"));
            }
        }

        JPanel com = new JPanel();
        com.setBorder(comBorder);// set border round com grid        
        com.setLayout(new GridLayout(4,4));
        grid=new JButton[width][length]; //allocate the size of grid
        for(int y=0; y<length; y++){
            for(int x=0; x<width; x++){
                grid[x][y]=new JButton(); //creates new button
                com.add(grid[x][y]); //adds button to grid
                grid[x][y].setBackground(Color.BLUE);//sets grid background colour
                grid[x][y].setPreferredSize(new Dimension(40, 40));//sets each grid buttons dimensions
                grid[x][y].addActionListener(
                    createActionListener(x, y, "Computer"));
            }
        }        

        //this.setLayout(new FlowLayout());
        this.add(player);
        this.add(com);

    }
    private ActionListener createActionListener(
        final int x, final int y, final String name)
    {
        return new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                clickedButton(x, y, name);
            }
        };
    }

    private void clickedButton(int x, int y, String name)
    {
        System.out.println("Clicked "+x+" "+y+" for "+name);
    }
}