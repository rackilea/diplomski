public static String convertToDigit(String s010){
    s010 = s010.toLowerCase();
    String s001= s010.substring(0,3);
    String s002 = s010.substring(4,6);
    String s003 = s010.substring(8,12);
    String s1 = (s001+s002+s003);
    String s2 = "";

    // Exceptions to our problem to stop invalid inputs 
    if (s1 == null) {
      System.out.print (" invalid input null thing"); 
    }
    if (s1.length() != 10){
      System.out.print (" invalid input"); 
    }

    String s6 = "";
    for (int i=0; i < s1.length(); i++) {


      if (Character.isDigit(s1.charAt(i))){
        s2 += s1.charAt(i); 
      }

      //sorting of the letter inputs 
      char ch = s1.charAt(i); 

      if (ch == 'a'||ch=='b'||ch== 'c'){
        s2 += "2"; 
      }
      if (ch == 'd'||ch=='e'||ch=='f'){
        s2 += "3"; 
      }
      if (ch == 'g'||ch=='h'||ch=='i'){
        s2 += "4"; 
      }
      if (ch == 'j'||ch=='k'||ch=='l'){
        s2 += "5"; 
      }
      if (ch == 'm'||ch=='n'||ch=='o'){
        s2 += "6"; 
      }
      if (ch == 'p'||ch=='q'||ch=='r'|| ch=='s'){
        s2 += "7"; 
      }
      if (ch == 't'||ch=='u'||ch=='v'){
        s2 += "8"; 
      }
      if (ch == 'w'||ch=='x'||ch=='y'|| ch=='z')
      {
        s2 += "9"; 
      }
      else{ 
      }

// They should not be here
/*   String s3 = s2.substring(0,3);
    String s4 = s2.substring(3,6);
    String s5 = s2.substring(6);
     s6 = ( s3 +"-"+ s4 + "-"+ s5);*/
    } // end of for loop; completed constructing s2

// They should be here
String s3 = s2.substring(0,3);
String s4 = s2.substring(3,6);
String s5 = s2.substring(6);
s6 = ( s3 +"-"+ s4 + "-"+ s5);

return s6; 
}