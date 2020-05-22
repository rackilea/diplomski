float rec1 = 0;

   if(isNumeric(receive)){
       rec1 = Float.parseFloat(receive);
       if(rec1 < total){

         JOptionPane.showMessageDialog(null,"Insufficient Amount");

       }
   }else {
          JOptionPane.showMessageDialog(null,"Enter a Valid Amount");
            c.jTextField1.setText("");
         }