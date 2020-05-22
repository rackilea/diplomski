text = "someString";
JPanel jp = new JPanel();

String str1 = "<html><div color='red'><u>"+text+"</u></div></html>"; //color1
String str2 = "<html><div color='#c0c0c0'><u>"+text+"</u></div></html>"; //color2

JLabel jl = new JLabel(str1);
jl.addMouseListener(this);
jp.add(jl);


@Override
public void mouseEntered(MouseEvent e) {
  JLabel jl = (JLabel) e.getSource();
  currentString = jl.getText();
  jl.setText(str2); // this will change the text to color 2
}

@Override
public void mouseExited(MouseEvent e) {
  JLabel jl = (JLabel) e.getSource();
  jl.setText(str1); // Return to original color
}