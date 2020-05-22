public class JBtnExample {
    public static void main(String[] args) {
        JButton btnOne = new JButton();
        JButton btnTwo = new JButton();

        ActionClass actionEvent = new ActionClass();

        btnOne.addActionListener(actionEvent);
                btnTwo.addActionListener(actionEvent);

        btnOne.setActionCommand("1");
        btnTwo.setActionCommand("2");
    }
} 

class ActionClass implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        int action = Integer.parseInt(e.getActionCommand());
        switch (action) {
        case 1:
            // DOSomething
            break;
        case 2:
            // DOSomething
            break;                          
        default:
            break;
        }
    }
}