String theReadLineFromTextFile = ....;

theReadLineFromTextFile = "<html>"+theReadLineFromTextFile+"</html>";
JLabel label = new JLabel(theReadLineFromTextFile);
//or 
JLabel label = new JLabel();
label.setText(theReadLineFromTextFile);