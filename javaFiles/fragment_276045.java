public class MainWindow extends JFrame {
    private JTextField jtfCustomerName=new JTextField(8);
    private JTextField jtfPassword=new JTextField(20);
    private Customer result;

    public MainWindow(){

        JPanel p1 = new JPanel(new GridLayout(3,2));
        p1.add(new JLabel("Customer name:"));
        p1.add(jtfCustomerName);
        p1.add(new JLabel("Password:"));
        p1.add(jtfPassword);
        Button login = new Button("login");
        p1.add(login);
        add(p1,BorderLayout.CENTER);
        login.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                result = new Customer(jtfCustomerName.getText(), jtfPassword.getText()); //set the result here
                setVisible(false); //hide this window
            }
        });
    }

    public Customer getResult()
    {
        return result;
    }
}