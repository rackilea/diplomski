public class Main() {
    JTextField userIDField;

    public static void main(String[] args) {
        userIDField = new JTextField();
        Login login = new Login(userIDField);
        AddSale addSale = new AddSale(userIDField);
        Frame frame = new JFrame();
        // ... and so on ...
        button.addActionListener(addSale);
    }
}

public class AddSale implements ActionListener {
    private final Login login;

    public AddSale(Login login) {
        this.login = login;
    }

    private void confirmAddSalesActionPerformed(java.awt.event.ActionEvent evt) {                                                
        String sample = login.getUserID();
        System.out.println(sample+"<------------------check if sample is working");
    }
}