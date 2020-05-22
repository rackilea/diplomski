public class JFrame2 {
 private JFrame1 frame1;

 public JFrame2(JFrame1 frame1) {
  this.frame1 = frame1;
 }

 private void button2(java.awt.event.ActionEvent evt){
  this.setVisible(false);

  frame1.setVisible(true);
 }
}