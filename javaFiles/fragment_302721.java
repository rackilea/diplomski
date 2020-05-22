public static boolean test1(String a, char b){
         for(int i=0;i<a.length();i++) {
             if(a.charAt(i)==b)
                 return true;
         }
         return false;
     }