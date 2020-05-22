import java.util.Arrays;

public class Test {

      public static String [] changeArrayToPalindrome(String [] arr){
          int length =arr.length;
          String[]newarray= new String[length];
          for(int i=0; i<length; i++){
             String a=arr[i];

             if(a==null){
                newarray[i]=null;
             }
             else if(a.equals("")){
              newarray[i]="";
             } else {
                 int n=a.length();
                 String newString="";
                 if (n%2==0) {
                     //for even
                     newString=a.substring(0,n/2); 
                 } else {
                     newString=a.substring(0,n/2+1);
                 }


                 for(int j=n/2-1; j>=0; j--){        
                    newString+=a.charAt(j);

                 }
                 newarray[i]=newString;
             }

          }
          return newarray;
      }  

    public static void main(String[] args) {
        String [] array={"street", null, "break", "oha", "", "pit", null,"atOyotA"};
        System.out.println(Arrays.toString(changeArrayToPalindrome(array)));

    }

}