public class CreateAccountGUI extends javax.swing.JFrame {

    public CreateAccountGUI() {
        /**/
        JButton btnCreateAccount = new JButton("Create");
        AccountStrategyController controller = new AccountStrategyController();
        controller.setView(this);
        btnCreateAccount.addActionListener(controller.createAccountListener());
    }
}

class AccountStrategyController{

    private CreateAccountGUI view = null;

    public void setView(CreateAccountGUI view){
        this.view = view;
        view.setVisible(true);//Show the account creation form
    }

    public  ActionListener createAccountListener(){     
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //respond to button click 
            }
        };
    }   
}