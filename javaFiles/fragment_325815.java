class Even implements Attribute
 {
     public boolean matches(boolean someBoolean, int num)
     {
         // someBoolean is not important to this attribute
         // but it may be in others
         return num%2==0;
     }
 }