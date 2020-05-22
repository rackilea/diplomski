public class LimitActionHandler implements ActionListener {

    private LimitPanel limitPane;

    public LimitActionHandler(LimitPanel limitPane) {
        this.limitPane = limitPane;
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        /*...*/
        // Use what ever was last assigned to "lp"
        jcb = limitPane.getChecks();
        // You can check this by using the hashCode of the object...
        System.out.println(limitPane.hashCode());
        /*...*/
    }
}