import javax.swing.*;
import java.awt.*;

public class FrmMainMenu {
    public static void main(String main[]){
        //Create Frame
        JFrame frmMainMenu = new JFrame();

        //Size Frame
        frmMainMenu.setExtendedState(JFrame.MAXIMIZED_BOTH);

        //Add Components
        comLeftToolBar obj1 = new comLeftToolBar();
        obj1.comCreateNavBar();
        frmMainMenu.add(obj1);

        frmMainMenu.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        //Display Frame
        frmMainMenu.setVisible(true);
    }
}

class comLeftToolBar extends JPanel{

    //Create ToolBar
    public void comCreateNavBar() {
        setLayout(new BorderLayout());
        JToolBar comNavToolBar = new JToolBar();
        comNavButtons(comNavToolBar);

        add(comNavToolBar, BorderLayout.PAGE_START);
    }

    //Create Buttons
    public void comNavButtons(JToolBar comNavToolBar) {
        JButton comNavButton = new JButton("Nav");
        JButton comProButton = new JButton("Pro");

        comNavToolBar.add(comNavButton);
        comNavToolBar.add(comProButton);
    }

    //Create Navigation Bar
    public void comLeftNavBar() {
        JPanel comNavBar = new JPanel();
        comNavBar.add(new comLeftToolBar());
    }
}