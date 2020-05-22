klick.addActionListener(new ActionListener() {
     public void actionPerformed(ActionEvent ae){
       klicks += k;
       test.setText("Gold:" + " " + klicks);
       if (klicks >= 10) {
         GUI.this.add(upgrade1);
       }
     }
   });