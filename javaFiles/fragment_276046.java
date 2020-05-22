public class CustomerLoginGUIAPP {
    public static void main(String[] args) {
        MainWindow main= new MainWindow();
        main.setSize(600,400);
        main.setLocation(300,300);
        main.setVisible(true);
        Customer customer = main.getResult(); //get the saved result
        System.out.println("Account num is " + customer.getAccNum());
    }
}