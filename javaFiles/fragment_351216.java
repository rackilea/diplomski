import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CardLayoutExample {
    private CardLayout cardLayout = new CardLayout(20, 20);
    private JPanel contentPane = new JPanel(cardLayout);

    private final static String p1 = "Panel 1";
    private final static String p2 = "Panel 2";

    private void displayGUI()
    {        
        MenuBar menuBar = new MenuBar();
        JFrame frame = new JFrame("Card Layout Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        contentPane.add(createPanel(Color.BLACK), p1); 
        contentPane.add(createPanel(Color.RED), p2);   

        frame.setContentPane(contentPane);   
        frame.setJMenuBar(menuBar.getMenuBar());
        frame.pack();   
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public JPanel createPanel(Color color) {
        JPanel panel = new JPanel();
        panel.setBackground(color);

        return panel;
    }

    public void redCard() {
        System.out.println("Selected Red Item ");
        ((CardLayout)contentPane.getLayout()).show(contentPane, p2);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                new CardLayoutExample().displayGUI();
            }
        });
    }

  // Inner Menu Bar class
  class MenuBar {

      private JMenuBar menuBar;
      private MenuActionListener mal;

      public MenuBar() {
          mal = new MenuActionListener();
          System.out.println("menuBar");

          //Creates a menubar for a JFrame
          menuBar = new JMenuBar();

          //Define and add drop down menu to the menubar
          JMenu mainMenu = new JMenu("Main Menu");
          menuBar.add(mainMenu);

          //Define addMenu items
          JMenuItem addRedItem = new JMenuItem("Red");
          addRedItem.addActionListener(mal);

          //Add main menu items/menu
          mainMenu.add(addRedItem);
      }

      public JMenuBar getMenuBar()
      {
          return menuBar;
      }

  }

  //Inner MenuActionListener class
  class MenuActionListener implements ActionListener {

      public void redActionPerformed() {
         // Call the redCard() method in outer object.
          redCard();
      }
      @Override
      public void actionPerformed(final ActionEvent e) {
          String command = e.getActionCommand();
          System.out.println(command);

          switch (command) {

              case "Red":
                  redActionPerformed();
                  break;

              default:
          }
      }
  }

}