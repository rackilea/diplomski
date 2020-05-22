import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GuiController extends JFrame {

    private boolean isRedShowing;

    public GuiController(){

        setTitle("CardLayout Demo");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        CentreFrameController centreFrameController = new CentreFrameController();
        centreFrameController.showRedPane();
        isRedShowing = true;
        setLayout(new BorderLayout());
        add(centreFrameController,BorderLayout.CENTER);
        JButton toggle = new JButton("Toggle");
        toggle.addActionListener(e ->{
            if(! isRedShowing) {
                centreFrameController.showRedPane();
            } else {
                centreFrameController.showYelloPane();
            }
            isRedShowing = ! isRedShowing;
        });
        add(toggle,BorderLayout.PAGE_END);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        new GuiController();
    }
}

class CentreFrameController extends JPanel {

    public final String YELLOW_PAGE = "yellow page";
    public final String RED_PAGE = "red page";
    private final CardLayout cLayout;

    public CentreFrameController(){

        cLayout = new CardLayout();
        setLayout(cLayout);
        setPreferredSize(new Dimension(200, 150));
        add(YELLOW_PAGE, new YellowPane());
        add(RED_PAGE, new RedPane());
    }

    //two convenience methods that encapsulate CardLayout#show(Container, String)
    void showRedPane() {
        cLayout.show(this, RED_PAGE);
    }

    void showYelloPane() {
        cLayout.show(this, YELLOW_PAGE);
    }
}

class RedPane extends JPanel{

    RedPane(){
        setBackground(Color.RED);
    }
}

class YellowPane extends JPanel{

    YellowPane(){
        setBackground(Color.YELLOW);
    }
}