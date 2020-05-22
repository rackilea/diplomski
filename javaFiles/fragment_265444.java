import java.awt.*;
import javax.swing.*;

public class GridBagPanelLayout
{
    private JPanel portrait1;
    private JPanel portrait2;
    private JPanel portrait3;
    private JPanel portrait4;
    private JPanel centerPanel;

    private JPanel actionPane;

    private void createAndDisplayGUI()
    {
        JFrame frame = new JFrame("GridBag JPanel Layout Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /*
         * This JPanel will serve as the 
         * Content Pane, for the JFrame.
         */
        JPanel contentPane = new JPanel();
        contentPane.setOpaque(true);
        contentPane.setBackground(Color.WHITE);
        contentPane.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.33;
        gbc.weighty = 0.5;
        gbc.gridheight = 2;

        portrait1 = new JPanel();
        portrait1.setOpaque(true);
        portrait1.setBackground(Color.BLUE);
        portrait1.setBorder(
                    BorderFactory.createMatteBorder(
                            2, 2, 2, 2, Color.WHITE));
        contentPane.add(portrait1, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weighty = 1.0;
        gbc.gridheight = 4;

        centerPanel = new JPanel();
        centerPanel.setOpaque(true);
        centerPanel.setBackground(Color.WHITE);
        centerPanel.setLayout(new GridBagLayout());
        GridBagConstraints constCenter = new GridBagConstraints();
        constCenter.anchor = GridBagConstraints.FIRST_LINE_START;
        constCenter.fill = GridBagConstraints.BOTH;
        constCenter.gridx = 0;
        constCenter.gridy = 0;
        constCenter.weightx = 1.0;
        constCenter.weighty = 0.975;

        actionPane = new JPanel();
        actionPane.setOpaque(true);
        actionPane.setBackground(Color.MAGENTA);
        actionPane.setBorder(
                    BorderFactory.createMatteBorder(
                            2, 2, 2, 2, Color.WHITE));
        centerPanel.add(actionPane, constCenter);

        constCenter.gridx = 0;
        constCenter.gridy = 1;
        constCenter.weighty = 0.025;

        centerPanel.add(getMenuBar(), constCenter); 
        contentPane.add(centerPanel, gbc);  

        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.weighty = 0.5;
        gbc.gridheight = 2;

        portrait3 = new JPanel();
        portrait3.setOpaque(true);
        portrait3.setBackground(Color.BLUE);
        portrait3.setBorder(
                    BorderFactory.createMatteBorder(
                            2, 2, 2, 2, Color.WHITE));
        contentPane.add(portrait3, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        //gbc.weighty = 0.5;
        //gbc.gridheight = 2;

        portrait2 = new JPanel();
        portrait2.setOpaque(true);
        portrait2.setBackground(Color.BLUE);
        portrait2.setBorder(
                    BorderFactory.createMatteBorder(
                            2, 2, 2, 2, Color.WHITE));
        contentPane.add(portrait2, gbc);

        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.weighty = 0.5;
        gbc.gridheight = 2;

        portrait4 = new JPanel();
        portrait4.setOpaque(true);
        portrait4.setBackground(Color.BLUE);
        portrait4.setBorder(
                    BorderFactory.createMatteBorder(
                            2, 2, 2, 2, Color.WHITE));
        contentPane.add(portrait4, gbc);

        frame.setContentPane(contentPane);
        frame.setSize(500, 300);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    private JMenuBar getMenuBar()
    {
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        fileMenu.setOpaque(true);
        fileMenu.setBackground(Color.BLACK);
        fileMenu.setForeground(Color.WHITE);
        JMenuItem newItem = new JMenuItem("NEW");
        JMenuItem openItem = new JMenuItem("OPEN");
        fileMenu.add(newItem);
        fileMenu.add(openItem);

        JMenu editMenu = new JMenu("Edit");
        editMenu.setOpaque(true);
        editMenu.setBackground(Color.BLACK);
        editMenu.setForeground(Color.WHITE);
        JMenuItem redoItem = new JMenuItem("Redo");
        JMenuItem undoItem = new JMenuItem("Undo");
        editMenu.add(redoItem);
        editMenu.add(undoItem);

        JMenu viewMenu = new JMenu("View");
        viewMenu.setOpaque(true);
        viewMenu.setBackground(Color.BLACK);
        viewMenu.setForeground(Color.WHITE);
        JMenuItem zInItem = new JMenuItem("Zoom In");
        JMenuItem zOutItem = new JMenuItem("Zoom Out");
        viewMenu.add(zInItem);
        viewMenu.add(zOutItem);

        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(viewMenu);
        menuBar.setOpaque(true);
        menuBar.setBackground(Color.BLACK);     

        return menuBar;
    }

    public static void main(String... args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                new GridBagPanelLayout().createAndDisplayGUI();
            }
        });
    }
}