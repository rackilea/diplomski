try {
    String string = textView.getText().toString(); 
    int num = Integer.parseInt(string);  
    textView.setText(String.valueOf(--num)); 
catch(NumberFormatException ignored){

}