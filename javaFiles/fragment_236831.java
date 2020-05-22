public static String altCase(String text){
      String str = "";
      str += Character.toUpperCase(text.charAt(0));
      for (int i = 1; i <= text.length()-1; i++)
      {
        char ch = text.charAt(i);
        boolean lastUp = flipFlop(i);
        char temp = switcher(ch, lastUp);
        str+=temp;
      }
      return str;
 }
 public static boolean flipFlop (int i){
      boolean bool = true;
      if(i==1){
        bool = true;
      }
      else if((i%2)==0)
      {
           bool = false;
      }
      else if((i%2)!=0)
      {
           bool = true;
      }
      return bool;
 }
 public static char switcher (char ch, boolean lastUp){
   char temp = ch;
   if(lastUp){
        temp = Character.toLowerCase(ch);
   }
   else if (lastUp==false){
     temp = Character.toUpperCase(ch);
   }
   return temp;
 }