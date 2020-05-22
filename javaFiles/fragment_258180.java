class MyClass extends JFrame implements ActionListener{
      // Declare here to make visible to actionPerformed
      JButton b = new JButton("Click here"); 

       MyClass(){    
        super("Test");
        b.addActionListener(this);
        add(b);
        setVisible(true);
        setSize(250,250);    
       }

       public void actionPerformed(ActionEvent e){
         if ( e.getSource() == b ){ 
         //do something 
         }
       }
       public static void main(String[] args){
            new MyClass();
       }
   }