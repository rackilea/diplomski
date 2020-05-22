char eng = jTextField1.getText().charAt(0);  //if you method return a String it gets the 1st character
switch(eng){
   case'a':
   case'e':
   case'i':
   case'o': 
   case'u': jTextField2.setText("It is a vowel");
            break;
   default: jTextField2.setText("It is not a vowel");
            break;
 }