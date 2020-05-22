public class MyOwnListener implements ActionListener {
     @Override
     public void actionPerformed(ActionEvent e) {
         if(e.getSource() == button1) {
             executeCodeForButton1();
         } else if(e.getSource() == button2) {
             executeCodeForButton2();
         }
     }
}