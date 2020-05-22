private static String displayMultiple(Displayable d, int count){
   String s = "";
   String ss = d.getDisplayText();
   for(int i=0; i<count; i++){
      s += ss;
   }
   return s;
}