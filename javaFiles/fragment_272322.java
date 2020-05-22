public void afterTextChanged(Editable s) {

     //Convert this to a number i.e. 
     int myNum = Integer.parseInt(s.toString());

     //Examine the value and replace..
     if (myNum > 60)
     {
       s.replace(0, s.length(), "60", 0, 2);
     }
}