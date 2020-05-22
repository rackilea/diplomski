class Sample{
   private int j;

   void method() {
     ...
     nextButton.setBounds(750, 250, 80, 30);
     nextButton.addActionListener(new ActionListener() {
       public void actionPerformed(ActionEvent ae){
           j++;
           doNext(j, nextButton);
       }
      });
    }
}