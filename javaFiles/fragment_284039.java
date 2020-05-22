import java.awt.*;
import javax.swing.*;

public class GridBagLayoutExample
{
    private GridBagConstraints gbc;

    public GridBagLayoutExample()
    {
        gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
    }

    private void displayGUI()
    {
        JFrame frame = new JFrame("GridBagLayout Example");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel contentPane = getPanel(Color.WHITE);
        contentPane.setLayout(new GridBagLayout());

        JPanel leftPanel = getPanel(Color.BLUE);
        JPanel rightPanel = getPanel(Color.RED);
        JPanel bottomPanel = getPanel(Color.GREEN.darker());

        addComp(contentPane, leftPanel
                , 0, 0, 0.7, 0.9, 1, 1, GridBagConstraints.BOTH);
        addComp(contentPane, rightPanel
                , 1, 0, 0.3, 0.9, 1, 1, GridBagConstraints.BOTH);
        addComp(contentPane, bottomPanel
                , 0, 1, 1.0, 0.1, 2, 1, GridBagConstraints.BOTH);

        frame.setContentPane(contentPane);
        //frame.pack();
        frame.setSize(300, 300);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    private void addComp(JPanel panel, JComponent comp
                            , int gridX, int gridY
                            , double weightX, double weightY
                            , int gridWidth, int gridHeight, int fill)
    {
        gbc.gridx = gridX;
        gbc.gridy = gridY;
        gbc.weightx = weightX;
        gbc.weighty = weightY;
        gbc.gridwidth = gridWidth;
        gbc.gridheight = gridHeight;
        gbc.fill = fill;

        panel.add(comp, gbc);
    }

    private JPanel getPanel(Color backColour)
    {
        JPanel panel = new JPanel();
        panel.setOpaque(true);
        panel.setBackground(backColour);
        panel.setBorder(
            BorderFactory.createEmptyBorder(5, 5, 5, 5));

        return panel;
    }

    public static void main(String[] args)
    {
        Runnable runnable = new Runnable()
        {
            @Override
            public void run()
            {
                new GridBagLayoutExample().displayGUI();
            }
        };
        EventQueue.invokeLater(runnable);
    }
}