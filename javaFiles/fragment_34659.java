import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class mainView {

    private static JFrame main; //main frame we add everything too
    private static JPanel newGame; //panel for new game        
    private static JPanel dropDownPanel; //panel for the combobox 

    private static CardLayout clayout; //cardlayout for new game
    private static JComboBox dropDown; //dropdown combobox  
    ImageIcon eastImg;

    public void codeNameView() {
        main = new JFrame("CodeNames");
        main.setSize(600, 900);

        //dropdown menu for quit and new game
        String[] choice = {" ", "NewGame", "Quit"};
        dropDown = new JComboBox(choice);

        //below is the panel where we add new game and quit options too
        dropDownPanel = new JPanel();
        dropDownPanel.setSize(100, 100);
        dropDownPanel.add(dropDown);
        main.getContentPane().add(dropDownPanel, BorderLayout.NORTH);

        //easter egg
        JButton easterButt = new JButton("Pass CSE 116");
//      JLabel eastLbl = new JLabel();
//      //added button to JLabel
//      eastLbl.add(easterButt);
        try {
            String path = "/GUI/MatthewPhoto.jpg";
            eastImg = new ImageIcon(ImageIO.read(this.getClass().getResource(path)));

        } catch (Exception ex) {
            System.out.print(ex);
        }
        //added label to Panel
        dropDownPanel.add(easterButt);
        easterButt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                easterButt.setIcon(eastImg);
            }
        });

        //action listener for dropdown combobox
        dropDown.addActionListener(new ActionListener() {

            /**
             * Allows for the user to select New Game or Quit and have the game
             * perform said action
             */
            @Override
            public void actionPerformed(ActionEvent e) {

                // TODO Auto-generated method stub
                JComboBox cb = (JComboBox) e.getSource();
                Object selectedOption = dropDown.getSelectedItem();

                if (selectedOption.equals("Quit")) {
                    main.dispose();
                } else if (selectedOption.equals("NewGame")) {

                    codeNameView();
                    System.out.print("yolo");

                }
            }

        });
        main.setVisible(true);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello");
                mainView x = new mainView();
                x.codeNameView();
                // create a instance on mainview to run instead of using static methods
            }
        });
    }
}