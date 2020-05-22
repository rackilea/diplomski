public class MainPanel extends JPanel {

    private JTextField username;
    private JPasswordField password;
    private JLabel passwordLbl;
    private JLabel usernameLbl;
    private GridBagConstraints gc;
    private Image img;

    public MainPanel() {
        img = getToolkit().getImage("pics/blue_and_red.jpg");

        username = new JTextField(10);
        password = new JPasswordField(10);
        passwordLbl = new JLabel("Password: ");
        usernameLbl = new JLabel("Username: ");

        // usernameLbl.setOpaque(true);
        // passwordLbl.setOpaque(true);

        setLayout(new GridBagLayout());

        gc = new GridBagConstraints();
        gc.weightx = 1;
        gc.weighty = 1;

        gc.gridx = 1;
        gc.gridy = 0;
        add(username, gc);

        gc.gridx = 1;
        gc.gridy = 1;
        add(password, gc);

        gc.gridx = 0;
        gc.gridy = 0;
        add(usernameLbl, gc);

        gc.gridx = 0;
        gc.gridy = 1;
        add(passwordLbl, gc);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (img != null) {
            g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
        }

        // username.repaint();
        // password.repaint();
        // usernameLbl.setOpaque(true);
        // usernameLbl.repaint();
        // passwordLbl.repaint();
    }

    private static void createAndShowGui() {
      // create JFrame
      JFrame frame = new JFrame("BUI");
      frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

      // add our MainPanel to the JFrame
      frame.getContentPane().add(new MainPanel());
      frame.pack(); // pack it
      frame.setLocationByPlatform(true);
      frame.setVisible(true); // show it
   }

   public static void main(String[] args) {
      // this is for starting our Swing app on the event thread
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            createAndShowGui();
         }
      });
   }

}