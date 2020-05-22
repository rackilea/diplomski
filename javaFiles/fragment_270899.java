public class test 
    { 
        public static void main(String y) 
        { 
            int l =y.length(); 
            for(int i=0;i<=l-1;i++) 
            { 
                if(y.charAt(i)!='g' && y.charAt(i)!='n') 
                    System.out.print(y.charAt(i)); 
                else continue; 
            }
        } 
    }