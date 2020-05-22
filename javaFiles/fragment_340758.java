import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ATMgui extends JFrame implements ActionListener 
{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    public static final int WIDTH = 500;
    public static final int HEIGHT = 200;
    private ATMbizlogic theBLU;// short for the Business Logic Unit
    private JPanel txPanel;
    public JLabel totalBalanceLabel;
    public JTextField withdrawTextField;
    public JTextField depositTextField;
    public JTextField pinTextField;

    /**
     * Creates a new instance of ATMgui
     */
    public ATMgui() 
    {
        setTitle("ATM Transactions");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Container contentPane = getContentPane();
        contentPane.setBackground(Color.BLACK);
        contentPane.setLayout(new BorderLayout());


        // Do the panel for the rest stop
        JLabel start = new JLabel("Welcome To Your Account", JLabel.CENTER);
        Font curFont = start.getFont();
        start.setFont(new Font(curFont.getFontName(), curFont.getStyle(), 25));
        start.setForeground(Color.BLUE);
        start.setOpaque(true);
        start.setBackground(Color.BLACK);


        pinTextField = new JTextField();
        JLabel pinLabel = new JLabel("Enter your PIN below:", JLabel.CENTER);
        pinLabel.setForeground(Color.RED);
        pinLabel.setOpaque(true);
        pinLabel.setBackground(Color.WHITE);



        JButton pinButton = new JButton("Enter Pin OK");
        pinButton.addActionListener(this);
        pinButton.setBackground(Color.red);

        JPanel pinPanel = new JPanel();
        pinPanel.setLayout(new GridLayout(3, 1, 100, 0));

        pinPanel.add(pinLabel);
        pinPanel.add(pinTextField);
        pinPanel.add(pinButton);

        contentPane.add(pinPanel, BorderLayout.WEST);


        JPanel headingPanel = new JPanel();
        headingPanel.setLayout(new GridLayout());
        headingPanel.add(start);

        contentPane.add(headingPanel, BorderLayout.NORTH);


        // Do the panel for the amount & type of transactions
        withdrawTextField = new JTextField();
        JLabel withdrawLabel = new JLabel("Withdraw (0.00)", JLabel.CENTER);
        withdrawLabel.setForeground(Color.RED);
        withdrawLabel.setOpaque(true);
        withdrawLabel.setBackground(Color.WHITE);



        depositTextField = new JTextField();
        JLabel depositLabel = new JLabel("Deposit (0.00)", JLabel.CENTER);
        depositLabel.setForeground(Color.RED);
        depositLabel.setOpaque(true);
        depositLabel.setBackground(Color.WHITE);



        JButton txButton = new JButton("Transactions OK");
        txButton.addActionListener(this);
        txButton.setBackground(Color.red);




        txPanel = new JPanel();
        txPanel.setLayout(new GridLayout(5, 1, 30, 0));

        txPanel.add(withdrawLabel);
        txPanel.add(withdrawTextField);
        txPanel.add(depositLabel);
        txPanel.add(depositTextField);
        txPanel.add(txButton);

        contentPane.add(txPanel, BorderLayout.EAST);
        txPanel.setVisible(false);


        totalBalanceLabel = new JLabel("Your balance after transactions: ", JLabel.CENTER);
        totalBalanceLabel.setForeground(Color.BLUE);
        totalBalanceLabel.setOpaque(true);
        totalBalanceLabel.setBackground(Color.BLACK);


        contentPane.add(totalBalanceLabel, BorderLayout.SOUTH);


        theBLU = new ATMbizlogic();
    }

    public void actionPerformed(ActionEvent e) 
    {
        String actionCommand = e.getActionCommand();

        // Container contentPane = getContentPane();

        if (actionCommand.equals("Transactions OK")) 
        {
            try 
            {
                double deposit = Double.parseDouble(depositTextField.getText().trim());
                double withdraw = Double.parseDouble(withdrawTextField.getText().trim());
                theBLU.computeBalance(withdraw, deposit);
                totalBalanceLabel.setText("Your balance after transactions: " + theBLU.getBalance());

            } 
            /*catch (ATMexception ex) 
            {
                totalBalanceLabel.setText("Error: " + ex.getMessage());
            }*/ 
            catch (Exception ex) 
            {
                totalBalanceLabel.setText("Error in deposit or withdraw amount: " + ex.getMessage());
            }
        } 
        else if (actionCommand.equals("Enter Pin OK")) 
        {

            try 
            {               
                double pin = Double.parseDouble(pinTextField.getText().trim());
                if(theBLU.checkPin(pin))
                    txPanel.setVisible(true);
                totalBalanceLabel.setText("Your balance after transactions: " + theBLU.getBalance());               
            } 
            /*catch (ATMexception ex) 
            {
                totalBalanceLabel.setText("Error: " + ex.getMessage());
            }*/ 
            catch (Exception ex) 
            {
                totalBalanceLabel.setText("Error in pin: " + ex.getMessage());
                ex.printStackTrace();
            }
        } 
        else 
        {
            System.out.println("Error in button interface.");
        }
    }

    public static void main(String[] args) 
    {
        ATMgui gui = new ATMgui();
        gui.setVisible(true);
    }
}

class ATMbizlogic 
{

    private double totalBalance;
    private boolean rightPinEntered;

    /**
     * Creates a new instance of ATMbizlogic
     */
    public ATMbizlogic() 
    {
        totalBalance = 0.0;
        rightPinEntered =  true;
    }

    public void computeBalance(double withdraw, double deposit)
    //throws ATMexception 
    {
        if(withdraw <=0)
        {
            System.out.println("Negative withdraw not allowed");
            //throw new ATMexception("Negative withdraw not allowed");
        }   

        if(deposit <=0)
        {
            System.out.println("Negative deposit not allowed");
            //throw new ATMexception("Negative deposit not allowed");
        }   

         double balance = deposit - withdraw;

        totalBalance = totalBalance + balance;
    }

    public boolean checkPin(double pin)
    //throws ATMexception 
    {
        if(pin <=0)
        {
            System.out.println("Negative pin not allowed");
            rightPinEntered = false;
            //throw new ATMexception("Negative pin not allowed");
        }   
        /*else if(rightPinEntered == false)
        {
            System.out.println("Can not take another pin");
            rightPinEntered = false;
            //throw new ATMexception("Can not take another pin");
        }*/ 
        else if(pin<1111 || pin>9999)
        {
            System.out.println("Enter a valid pin");
            rightPinEntered = false;
            //throw new ATMexception("Enter a valid pin");
        }
        else
        {       
            rightPinEntered = true;
        }

        return rightPinEntered;
    }

    public double getBalance()
    {
        return totalBalance;
    }
}