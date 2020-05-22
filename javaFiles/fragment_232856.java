@SuppressWarnings("serial")
class ButtonPanel extends JPanel {
   private Registration registration;

   public ButtonPanel() {
      setLayout(new GridLayout(1, 0, 10, 0));
      // go through String array making buttons
      for (final String keyText : Registration.KEY_TEXTS) {
         JButton btn = new JButton(keyText);
         btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               if (registration != null) {
                  registration.swapView(keyText);
               }
            }
         });
         add(btn);
      }
   }

   public void setRegistration(Registration registration) {
      this.registration = registration;
   }
}