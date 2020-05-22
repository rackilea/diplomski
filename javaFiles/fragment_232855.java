class OutsideClass {
   private Registration registration;
   private JButton jButtonAgree = new JButton("Agree");

   public OutsideClass() {
      jButtonAgree.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            // make sure registration reference has been obtained first!
            if (registration != null) { 
               registration.swapView(Registration.USER_AGREEMENT);
            }
         }
      });
   }

   // here I allow the calling class to pass a reference to the visualized
   // Registration instance.
   public void setRegistration(Registration registration) {
      this.registration = registration;
   }
}