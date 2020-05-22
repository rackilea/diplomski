public class jFrame1 extends javax.swing.JFrame{

   public JTextField txt1; // Hope you have initialized this somewhere in your code else you will face a NPE.
   private JButton btn1;

   btn1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
         jFrame2 jframe2 = new jFrame2(this, txt1.getText());
         jframe2.setVisible(true);
      }
   });


   .....

}


public class jFrame2 extends javax.swing.JFrame{

   private JFrame jframe1;
   private String text;
   public JTextField txtDemo; 

   public jFrame2(JFrame jframe){
      this.jframe1 = jframe;
   }

   public jFrame2(JFrame jframe, String text){
      this.jframe1 = jframe;
      txtDemo = new JTextField(text);
   }

   ...

}