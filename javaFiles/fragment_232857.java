class MainClass extends JPanel {
   public MainClass() {
      Registration registration = new Registration();
      ButtonPanel buttonPanel = new ButtonPanel();
      buttonPanel.setRegistration(registration);

      buttonPanel.setBorder(BorderFactory.createTitledBorder("Button Panel"));
      registration.setBorder(BorderFactory.createTitledBorder("Registration Panel"));

      setLayout(new BorderLayout());
      add(registration, BorderLayout.CENTER);
      add(buttonPanel, BorderLayout.SOUTH);
   }

   private static void createAndShowUI() {
      JFrame frame = new JFrame("Registration");
      frame.getContentPane().add(new MainClass());
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
   }

   public static void main(String[] args) {
      java.awt.EventQueue.invokeLater(new Runnable() {
         public void run() {
            createAndShowUI();
         }
      });
   }
}