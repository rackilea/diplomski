public class TheHandler {

    public TheHandler() {
        JButton login, cancel;

        //initialize code here

        login.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent logInEvent) {
                loginPerformed(logInEvent);
            }
        });
        cancel.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent cancelEvent) {
                cancelPerformed(cancelEvent);
            }
        });
    }

    public void loginPerformed(ActionEvent logInEvent) {
        System.out.println("Button Login");
    }

    public void cancelPerformed(ActionEvent cancelEvent) {
        System.out.println("Cancel Login");
    }
}