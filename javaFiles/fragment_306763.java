import java.awt.*;
import javax.swing.*;

public class Test {

  public static void main(String[] args){
    SwingUtilities.invokeLater(new Runnable() {
      @Override
      public void run() { 
        createAndShowGUI();
      }
    });
  }

  private static void createAndShowGUI() {
    JFrame frame = new JFrame();
    JPanel north = createNorthPanel();
    JPanel center = createCenterPanel();
    JPanel south = createSouthPanel();

    frame.add(north, BorderLayout.NORTH);
    frame.add(center, BorderLayout.CENTER);
    frame.add(south, BorderLayout.SOUTH);

    frame.setLocationByPlatform(true);
    frame.pack();
    frame.setVisible(true);
  }

  private static JPanel createNorthPanel() {
    JPanel northPanel = new JPanel();
    BoxLayout northPanelLayout = new BoxLayout(northPanel, BoxLayout.Y_AXIS);
    northPanel.setLayout(northPanelLayout);

    JPanel upperPanel = new JPanel();
    JLabel funFunGuessingGameLabel = new JLabel("FUN FUN Guessing Game");
    funFunGuessingGameLabel.setFont(funFunGuessingGameLabel.getFont().deriveFont(Font.ITALIC));
    upperPanel.add(funFunGuessingGameLabel);
    upperPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

    JPanel lowerPanel = new JPanel();
    BoxLayout lowerPanelLayout = new BoxLayout(lowerPanel, BoxLayout.X_AXIS);
    lowerPanel.setLayout(lowerPanelLayout);

    JButton startButton = new JButton("START");
    startButton.setPreferredSize(new Dimension(175,(int)startButton.getPreferredSize().getHeight()));
    JLabel entryBoxLabel = new JLabel("Entry Box: ");
    JTextField entryBoxTextField = new JTextField();

    lowerPanel.add(startButton);
    lowerPanel.add(Box.createHorizontalStrut(10));
    lowerPanel.add(entryBoxLabel);
    lowerPanel.add(entryBoxTextField);
    lowerPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

    northPanel.add(upperPanel);
    northPanel.add(lowerPanel);
    return northPanel;
  }

  private static JPanel createCenterPanel() {
    JPanel centerPanel = new JPanel();
    BoxLayout centerPanelLayout = new BoxLayout(centerPanel, BoxLayout.Y_AXIS);
    centerPanel.setLayout(centerPanelLayout);

    JLabel l1 = new JLabel("Guesses and statistics are shown in this display as a scrollable list, e.g.:                  ");
    JLabel l2 = new JLabel("(1,3,5)é(0,0)");
    JLabel l3 = new JLabel("(2,4,6)é(0,0)");
    JLabel l4 = new JLabel("(7,8,9)é(0,0)");
    Box space = Box.createVerticalBox();

    centerPanel.add(Box.createHorizontalStrut(10));
    centerPanel.add(l1);
    centerPanel.add(Box.createVerticalStrut(10));
    centerPanel.add(l2);
    centerPanel.add(Box.createVerticalStrut(5));
    centerPanel.add(l3);
    centerPanel.add(Box.createVerticalStrut(5));
    centerPanel.add(l4);
    centerPanel.add(Box.createVerticalStrut(40));
    centerPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

    return centerPanel;
  }


  private static JPanel createSouthPanel() {
    JPanel southPanel = new JPanel();
    BoxLayout southPanelLayout = new BoxLayout(southPanel, BoxLayout.Y_AXIS);
    southPanel.setLayout(southPanelLayout);

    JPanel upperPanel = new JPanel();
    BoxLayout upperPanelLayout = new BoxLayout(upperPanel, BoxLayout.X_AXIS);
    upperPanel.setLayout(upperPanelLayout);

    JPanel clearButtonPanel = new JPanel(new BorderLayout(0, 0));
    JButton clearButton = new JButton("CLEAR");
    clearButton.setPreferredSize(new Dimension(175, (int) clearButton.getPreferredSize().getHeight()));
    clearButtonPanel.add(clearButton);


    JPanel innerPanel = new JPanel();
    BoxLayout innerPanelLayout = new BoxLayout(innerPanel, BoxLayout.Y_AXIS);
    innerPanel.setLayout(innerPanelLayout);

    JPanel statisticsOptionsLabelPanel = new JPanel();
    JLabel statisticsOptionsLabel = new JLabel("Statistics Options");
    statisticsOptionsLabelPanel.add(statisticsOptionsLabel);

    JPanel checkBoxPanel = new JPanel();
    BoxLayout checkBoxPanelLayout = new BoxLayout(checkBoxPanel, BoxLayout.X_AXIS);
    checkBoxPanel.setLayout(checkBoxPanelLayout);

    JCheckBox bestTimeCheckBox = new JCheckBox("Best Time");
    JCheckBox bestNumOfPlaysCheckBox = new JCheckBox("Best  # of plays");
    JCheckBox topPlayerCheckBox = new JCheckBox("Top Player");

    checkBoxPanel.add(bestTimeCheckBox);
    checkBoxPanel.add(bestNumOfPlaysCheckBox);
    checkBoxPanel.add(topPlayerCheckBox);

    innerPanel.add(statisticsOptionsLabelPanel);
    upperPanel.add(Box.createVerticalGlue());
    innerPanel.add(checkBoxPanel);    

    upperPanel.add(clearButtonPanel);
    upperPanel.add(Box.createHorizontalStrut(14));
    upperPanel.add(innerPanel);
    upperPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

    JPanel lowerPanel = new JPanel();
    BoxLayout lowerPanelLayout = new BoxLayout(lowerPanel, BoxLayout.X_AXIS);
    lowerPanel.setLayout(lowerPanelLayout);

    JButton statsButton = new JButton("STATS");
    statsButton.setPreferredSize(new Dimension(175,(int)statsButton.getPreferredSize().getHeight()));
    JLabel haveFunLabel = new JLabel("Have Fun!!!");

    lowerPanel.add(statsButton);
    lowerPanel.add(Box.createHorizontalGlue());
    lowerPanel.add(haveFunLabel);
    lowerPanel.add(Box.createHorizontalGlue());
    lowerPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

    southPanel.add(upperPanel);
    southPanel.add(lowerPanel);
    return southPanel;
  }
}