int a = -1;
try {
    a = Integer.parseInt(theApp.tred.getText());
    if (a < 0) {
        a = 200; 
        tred.setText("200");
    }
    if (a > 255) {
        a = 255;
        tred.setText("255");
    }
    //do the needed things here
} catch (Exception e) {
    message.setText("invalid input! please enter numbers only"); // text
    message.setForeground(new Color(0, 0, 0)); 
    tred.setText("");
}