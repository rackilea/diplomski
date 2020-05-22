package Main;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import objects.BoardPane;
import objects.BoardSpace;

import javax.imageio.ImageIO;

public class Console {
    private JFrame gameConsole; 
    private JPanel centerConsole;
    private BoardPane gameContainer;
    private JPanel playerPanel;
    private JPanel gamePanel;
    private JPanel north;
    private JPanel south;
    private JPanel east;
    private JPanel west;
    private JLayeredPane center;
    private JPanel splash;
    private JPanel playerBox;
    private JPanel boardGrid;
    private JPanel boardImage;
    private JButton start;
    private BoardSpace [][] spaces;
    private BoardSpace [][] playerSpaces;

    public Console () throws IOException{
        // Create gameConsole
        gameConsole = new JFrame();
        final int frameWidth = 850;
        final int frameHeight = 950;
        gameConsole.setPreferredSize(new Dimension(frameWidth, frameHeight));
        gameConsole.setTitle("Scrabble");
        gameConsole.setLayout(new GridBagLayout());
        gameConsole.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.ipadx = 810;
        c.ipady = 950;

        // Create center console panel and add to gameConsole
        centerConsole = new JPanel();
        centerConsole.setLayout(new BorderLayout());
        gameConsole.add(centerConsole,c);


        // Create layered pane that holds the board and playerbox
        gameContainer = new BoardPane();
        gameContainer.setBounds(0,0,810,950);

        MouseInput mouseActions = new MouseInput();

        gameContainer.addMouseMotionListener(mouseActions);
        gameContainer.addMouseListener(mouseActions);
        centerConsole.add(gameContainer, BorderLayout.CENTER);

        // Create board image label and add to JPanel
        BufferedImage scrabbleImage = ImageIO.read(Console.class.getResource("/board.jpg"));    
        JLabel background = new JLabel(new ImageIcon(scrabbleImage));
        boardImage = new JPanel();
        boardImage.setBounds(0, 0, 810, 815);
        boardImage.add(background);
        boardImage.setOpaque(true);


        // create JPanel with gridBagLayout
        boardGrid = new JPanel();
        boardGrid.setBounds(0, 3, 810, 810);
        boardGrid.setLayout(new GridBagLayout());
        boardGrid.setOpaque(false);

        // Create panels to add to boardGrid
        spaces = new BoardSpace [15][15];
        BoardSpace.setBoardSpaces(spaces);

        // Set grid constraints
        GridBagConstraints cGrid = new GridBagConstraints();
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                // panel constraints
                cGrid.gridx = i;                // grid x location
                cGrid.gridy = j;                // grid y location
                cGrid.gridheight = 1;           // spans 1 row
                cGrid.gridwidth = 1;            // spans 1 column
                cGrid.weightx = 0.0;
                cGrid.weighty = 0.0;
                cGrid.fill = GridBagConstraints.BOTH;   // Resize veritically & horizontally

                // Set size of board space and add to grid
                spaces[i][j].setOpaque(false);
                spaces[i][j].setPreferredSize(new Dimension((int) Info.GRIDSIZE,(int) Info.GRIDSIZE));
                boardGrid.add(spaces[i][j], cGrid);
            }
        }

        // Add to layeredPane
        gameContainer.add(boardImage, new Integer(0),0);
        gameContainer.add(boardGrid, new Integer(1),0);


        // Create player box panel 
        playerPanel = new JPanel();
        playerPanel.setLayout(new GridBagLayout());
        playerBox = new JPanel();
        playerBox.setLayout(new GridLayout(1,7, 10, 0));

        // Create player box constraints
        GridBagConstraints cp = new GridBagConstraints();
        cp.ipadx = 50;
        cp.ipady = 50;

        // Create playerBox spaces
        playerSpaces = new BoardSpace [1][7];
        BoardSpace.setPlayerSpaces(playerSpaces);

        // Add playerSpaces to playerBox
        for (int j = 0; j < 7; j++) {
            // panel constraints
            cGrid.gridx = 0;                // grid x location
            cGrid.gridy = j;                // grid y location
            cGrid.gridheight = 1;           // spans 1 row
            cGrid.gridwidth = 1;            // spans 1 column
            cGrid.weightx = 0.0;
            cGrid.weighty = 0.0;
            cGrid.fill = GridBagConstraints.BOTH;   // Resize veritically & horizontally

            // Set size of board space and add to grid
            playerSpaces[0][j].setOpaque(false);
            playerSpaces[0][j].setPreferredSize(new Dimension((int) Info.GRIDSIZE,(int) Info.GRIDSIZE));
            playerBox.add(playerSpaces[0][j], cGrid);
        }

        // Add player box to south panel
        playerPanel.add(playerBox, cp);

        // Add player box to bottom of layeredPane
        playerPanel.setBounds(0,825,810,75);
        gameContainer.add(playerPanel, new Integer(0),0);

        gameConsole.pack();

        // Make gameConsole visible
        gameConsole.setVisible(true);
    }

}