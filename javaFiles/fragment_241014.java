import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FontSize extends JFrame implements ActionListener {
    private JButton increase, decrease;
    private JLabel sizeX, sizeValue;

    public static void main (String[]args) {
        FontSize changeFont = new FontSize();
        changeFont.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        changeFont.setTitle("Increase/Decrease Font Size");
        changeFont.setSize(900,700);
        changeFont.setVisible(true);
        changeFont.setLayout(new GridLayout(2,2));
    }

    public FontSize(){
        increase = new JButton("increase");
        increase.setBackground(Color.white);
        increase.setFont(increase.getFont().deriveFont(30.0f));
        add(increase);

        decrease = new JButton("decrease");
        decrease.setBackground(Color.white);
        decrease.setFont(decrease.getFont().deriveFont(30.0f));
        add(decrease);

        sizeX = new JLabel("X", SwingConstants.CENTER);
        sizeX.setBackground(Color.yellow);
        sizeX.setFont(sizeX.getFont().deriveFont(30.0f));
        add(sizeX);

        int temp = sizeX.getFont().getSize();
        sizeValue = new JLabel("",SwingConstants.CENTER);
        sizeValue.setText(String.valueOf(temp));
        sizeValue.setBackground(Color.yellow);
        sizeValue.setFont(sizeValue.getFont().deriveFont(30.0f));
        add(sizeValue);

        increase.addActionListener(this);
        decrease.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e) {
        String operation = e.getActionCommand();
        int temp = sizeX.getFont().getSize();
        int temp2 = Integer.parseInt(sizeValue.getText());

        if(operation.equals("increase")) {                       
            temp += 5;
            sizeX.setFont(new Font("Arial", Font.PLAIN, temp));

            temp2 += 5;
            sizeValue.setText(String.valueOf(temp2));

        } else if(operation.equals("decrease")) {
            temp -= 5;
            sizeX.setFont(new Font("Arial", Font.PLAIN, temp));

            temp2 -= 5;
            sizeValue.setText(String.valueOf(temp2));
        }
    }
}