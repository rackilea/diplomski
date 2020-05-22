public class MyTextField extends JTextField {
.
.
@Override
public void paintComponent(Graphics g) {
  super.paintComponent(g);
  if (this.getText().equals("")){
     g drawString( ...);
  }
}

}