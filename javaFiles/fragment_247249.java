import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 
public class FigurRitare
{
    public String Figur = " ";
    public Boolean activator = false;
    public int draw = 0;
    private JPanel mainPanel;
    private JButton registreraButton;
    private JTextField textField1;
    private JPanel DrawingBord;

    public FigurRitare() {
        registreraButton = new JButton("Submit");
        mainPanel = new JPanel();
        textField1 = new JTextField();

        mainPanel.setLayout(new GridLayout(2, 1));

        registreraButton.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String inputString = textField1.getText();
                    decider(inputString);
                }
            });

        mainPanel.add(registreraButton);
        mainPanel.add(textField1);
    }

    public static void main()
    {
        //Skapa ditt fönster
        JFrame frame = new JFrame("Hello World!");
        //Tala om att du vill kunna stänga ditt förnster med krysset i högra hörnet
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Ange storleken på ditt fönster och att det ska vara fast
        frame.setSize(500, 600);
        frame.setResizable(false);
        //Positionera ditt fönster i mitten av skärmen
        frame.setLocationRelativeTo(null);

        //Skapa en instans av din den här klassen som hanterar din panel
        FigurRitare myForm = new FigurRitare();
        frame.setLayout(null);
        //Lägg in din panel i programfönstret
        frame.setContentPane(myForm.mainPanel);
        //Visa programfönstret på skärmen
        frame.setVisible(true);
    }

    public void decider(String input)
    {
        ritPanel rita = new ritPanel();
        if (input.equalsIgnoreCase("Cirkel")) {
            JFrame NewFrame = new JFrame("Cirkel");
            NewFrame.setVisible(true);
            NewFrame.setSize(500, 500);
            NewFrame.add(rita);
            rita.whatToDraw(1);
            textField1.setText("");
            textField1.requestFocusInWindow();
        } else if (input.equalsIgnoreCase("Rektangel")) {
            JFrame NewFrame = new JFrame("Rektangel");
            NewFrame.setVisible(true);
            NewFrame.setSize(500, 500);
            NewFrame.add(rita);
            rita.whatToDraw(2);
            textField1.setText("");
            textField1.requestFocusInWindow();
        } else {
            JOptionPane.showMessageDialog(mainPanel, "Vänligen ange antingen cirkel eller rektangel i rutan ovanför");
            textField1.setText("");
            textField1.requestFocusInWindow();
        }
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        DrawingBord = new ritPanel();
    }

    class ritPanel extends JPanel {

        public void whatToDraw(int toDraw) {
            draw = toDraw;
            repaint();
        }

        @Override
        public void paintComponent(Graphics grafik) {
            super.paintComponent(grafik);
            if (draw == 2) {
                grafik.fillRect(100, 100, 100, 100);
            }
            if (draw == 1) {
                grafik.fillOval(100, 100, 100, 100);
            }
        }
    }
}