class abc implements ActionListener 
 {
     public void actionPerformed(ActionEvent e) 
         {
              System.out.println("This is another class");
         }
  }



   class xyz 
     {
          xyz()
           {
            JButton abuttob = new JButton();
            abuttob.addActionListener(new abc());
           }
       }