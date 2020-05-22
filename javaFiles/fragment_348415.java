import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Calculator extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;

    public static JFrame frame = new JFrame("Calculator");
    public JPanel panel = new JPanel(new GridLayout(6,0,4,4));
    public double currentNumber, nextNumber, total;
    public boolean numberPresent = false;
    public boolean addition = false, subtraction = false, multiplication = false, division = false;

    public void addComponents(int x, int y) {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
        frame.setSize(x,y);

        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        JButton button1 = new JButton("0");
        button1.addActionListener(this);
        button1.setActionCommand("ZERO");
        button1.setPreferredSize(new Dimension(20,20));

        JButton button2 = new JButton("1");
        button2.addActionListener(this);
        button2.setActionCommand("ONE");
        button2.setPreferredSize(new Dimension(20,20));

        JButton button3 = new JButton("2");
        button3.addActionListener(this);
        button3.setActionCommand("TWO");
        button3.setPreferredSize(new Dimension(20,20));

        JButton button4 = new JButton("3");
        button4.addActionListener(this);
        button4.setActionCommand("THREE");
        button4.setPreferredSize(new Dimension(20,20));

        JButton button5 = new JButton("4");
        button5.addActionListener(this);
        button5.setActionCommand("FOUR");
        button5.setPreferredSize(new Dimension(20,20));

        JButton button6 = new JButton("5");
        button6.addActionListener(this);
        button6.setActionCommand("FIVE");
        button6.setPreferredSize(new Dimension(20,20));

        JButton button7 = new JButton("6");
        button7.addActionListener(this);
        button7.setActionCommand("SIX");
        button7.setPreferredSize(new Dimension(20,20));

        JButton button8 = new JButton("7");
        button8.addActionListener(this);
        button8.setActionCommand("SEVEN");
        button8.setPreferredSize(new Dimension(20,20));

        JButton button9 = new JButton("8");
        button9.addActionListener(this);
        button9.setActionCommand("EIGHT");
        button9.setPreferredSize(new Dimension(20,20));

        JButton button10 = new JButton("9");
        button10.addActionListener(this);
        button10.setActionCommand("NINE");
        button10.setPreferredSize(new Dimension(20,20));

        JButton button11 = new JButton("CLEAR");
        button11.addActionListener(this);
        button11.setActionCommand("CLEAR");
        button11.setPreferredSize(new Dimension(20,20));

        JButton button12 = new JButton("+");
        button12.addActionListener(this);
        button12.setActionCommand("+");
        button12.setPreferredSize(new Dimension(20,20));

        JButton button13 = new JButton("-");
        button13.addActionListener(this);
        button13.setActionCommand("-");
        button13.setPreferredSize(new Dimension(20,20));

        JButton button14 = new JButton("x");
        button14.addActionListener(this);
        button14.setActionCommand("x");
        button14.setPreferredSize(new Dimension(20,20));

        JButton button15 = new JButton("/");
        button15.addActionListener(this);
        button15.setActionCommand("/");
        button15.setPreferredSize(new Dimension(20,20));

        JButton button16 = new JButton("=");
        button16.addActionListener(this);
        button16.setActionCommand("=");
        button16.setPreferredSize(new Dimension(20,20));

        panel.add(button8);
        panel.add(button9);
        panel.add(button10);
        panel.add(button5);
        panel.add(button6);
        panel.add(button7);
        panel.add(button2);
        panel.add(button3);
        panel.add(button4);
        panel.add(button1);
        panel.add(button12);
        panel.add(button13);
        panel.add(button16);
        panel.add(button14);
        panel.add(button15);
        panel.add(button11);
        frame.setContentPane(panel);
        frame.getContentPane().setBackground(Color.BLACK);//Set The Background color after adding the panel
        frame.setVisible(true);
    }

        @Override
        @SuppressWarnings("DeadBranch")
        public void actionPerformed(ActionEvent ea) {
        String action = ea.getActionCommand();
            if (numberPresent = true && action.equals("ZERO")) {  
                nextNumber = currentNumber; 
                currentNumber = 0;
                System.out.print("0");
            }
            if (numberPresent = false && action.equals("ZERO")) {  
                currentNumber = 0;
                numberPresent = true;
                System.out.print("0");
            }
            if (numberPresent = true && action.equals("ONE")) {  
                nextNumber = currentNumber;
                currentNumber = 1;
                System.out.print("1");
            }
            if (numberPresent = false && action.equals("ONE")) { 
                currentNumber = 1;
                numberPresent = true;
                System.out.print("1");
            }
            if (numberPresent = true && action.equals("TWO")) { 
                nextNumber = currentNumber; 
                currentNumber = 2;
                System.out.print("2");
            }
            if (numberPresent = false && action.equals("TWO")) {  
                currentNumber = 2;
                numberPresent = true;
                System.out.print("2");
            }
            if (numberPresent = true && action.equals("THREE")) { 
                nextNumber = currentNumber; 
                currentNumber = 3;
                System.out.print("3");
            }
            if (numberPresent = false && action.equals("THREE")) {  
                currentNumber = 3;
                numberPresent = true;
                System.out.print("3");
            }
            if (numberPresent = true && action.equals("FOUR")) { 
                nextNumber = currentNumber;
                currentNumber = 4;
                System.out.print("4");
            }
            if (numberPresent = false && action.equals("FOUR")) {
                currentNumber = 4;
                numberPresent = true;
                System.out.print("4");
            }
            if (numberPresent = true && action.equals("FIVE")) { 
                nextNumber = currentNumber; 
                currentNumber = 5;
                System.out.print("5");
            }
            if (numberPresent = false && action.equals("FIVE")) { 
                currentNumber = 5;
                numberPresent = true;
                System.out.print("5");
            }
            if (numberPresent = true && action.equals("SIX")) {  
                nextNumber = currentNumber; 
                currentNumber = 6;
                System.out.print("6");
            }
            if (numberPresent = false && action.equals("SIX")) {  
                currentNumber = 6;
                numberPresent = true;
                System.out.print("6");
            }
            if (numberPresent = true && action.equals("SEVEN")) {  
                nextNumber = currentNumber; 
                currentNumber = 7;
                System.out.print("7");
            }
            if (numberPresent = false && action.equals("SEVEN")) { 
                currentNumber = 7;
                numberPresent = true;
                System.out.print("7");
            }
            if (numberPresent = true && action.equals("EIGHT")) { 
                nextNumber = currentNumber; 
                currentNumber = 8;
                System.out.print("8");
            }
            if (numberPresent = false && action.equals("EIGHT")) {  
                currentNumber = 8;
                numberPresent = true;
                System.out.print("8");
            }
            if (numberPresent = true && action.equals("NINE")) {  
                nextNumber = currentNumber; 
                currentNumber = 9;
                System.out.print("9");
            }
            if (numberPresent = false && action.equals("NINE")) {  
                currentNumber = 9;
                numberPresent = true;
                System.out.print("9");
            }
            if (action.equals("CLEAR")) {
                currentNumber = 0;
                nextNumber = 0;
                total = 0;
                System.out.println("CLEARED");
            }
            if (action.equals("=")) {
                numberPresent = false;
                if (addition) {
                    System.out.println(" = " + (currentNumber + nextNumber));
                    total = (currentNumber + nextNumber);
                    currentNumber = total;
                    addition = false;
                }
                if (subtraction) {
                    System.out.println(" = " + (nextNumber - currentNumber));
                    total = (currentNumber - nextNumber);
                    currentNumber = total;
                    subtraction = false;
                }
                if (multiplication) {
                    System.out.println(" = " + (currentNumber * nextNumber));
                    total = (currentNumber * nextNumber);
                    currentNumber = total;
                    multiplication = false;
                }
                if (division) {
                    System.out.println(" = " + (nextNumber/ currentNumber));
                    total = (nextNumber / currentNumber);
                    currentNumber = total;
                    division = false;
                }
            }
            switch (action) {
                case "+":
                    addition = true;
                    System.out.print(" + ");
                    break;
                case "-":
                    subtraction = true;
                    System.out.print(" - ");
                    break;
                case "x":
                    multiplication = true;
                    System.out.print(" x ");
                    break;
                case "/":
                    division = true;
                    System.out.print(" / ");
                    break;
            }
    }

    public static void main(String[] args) {
        System.out.println("Only handles 1 digit inputs at once. *Almost* Fully Functional");
        Calculator calc = new Calculator();
        calc.addComponents(260, 325);
    }
}