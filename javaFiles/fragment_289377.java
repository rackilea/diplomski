public void auto() {  
    String result = "";
    String x = jTextField1.getText().toUpperCase();  
    String[] myName = x.split(" ");  
    for (int i = 0; i < myName.length; i++) {  
        String s = myName[i];
        result += s.charAt(0);
    }
    jDifferentTextField.setText(result);
}