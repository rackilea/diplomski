btn1.addActionListener(new ActionListener(){

   public void actionPerformed(ActionEvent ae){
       controller.action1();
   }
});

btn2.addActionListener(new ActionListener(){

   public void actionPerformed(ActionEvent ae){
       controller.action2(ae);
   }
});