public class Hotel extends JFrame {

    public JPanel pan;
    ...

    public Hotel() {
       super("Kiosk");
       createGUI();
       setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       setVisible(true);
       setSize(600,400);
    }

    public void createGUI(){

       pan =  new JPanel(new GridBagLayout());
       c = new GridBagConstraints();
       add(pan);
       ...