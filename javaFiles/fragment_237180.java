public MainGUIClass() {
   ...
   private int age = 1;
   ...
   ageOutputBox.setText("" + age);
   ...
   ageButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
           ageOutputBox.setText("" + (++age) ); 
      }

   });

 }