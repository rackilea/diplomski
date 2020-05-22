public static boolean SimpleSymbols(String s){
  String s1=s.trim();

  if(Character.isLetter(s1.charAt(0)) || Character.isLetter(s1.charAt(s1.length()-1)))
      return false;

  for (int i = 1 ; i <s.length()-1; i++) 
      if (Character.isLetter(s1.charAt(i)) && (s1.charAt(i-1)!='+' || s1.charAt(i+1)!='+'))
          return false;

  return true;
}