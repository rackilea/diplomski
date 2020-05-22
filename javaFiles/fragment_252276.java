import java.util.Arrays;
import java.util.Scanner;


public class jh {

    public static void main(String[] args) {
        String [] keywords={"auto","break","case","char","const","continue","default",
                "do","double","else","enum","extern","float","for","goto","if","int",
                "long","register","return","short","signed","sizeof","static","struct",
                "switch","typedef","union","unsigned","void","volatile","while" };
        Scanner sn = new Scanner (System.in);
        /* get the value from scanner.. do not scan a single input twice.
         In your code in line Arrays.asList(keywords).contains(sn.next())) {, you have 
         already got the input once. If you had tried entering another integer after that and you
         should have got the This is an INTEGER
        */
        String string = sn.next();
        Integer someInt = null;
        try{//see if the input was an integer 
         someInt= Integer.parseInt(string);
        }catch(NumberFormatException e){System.out.println(e);}

         if(Arrays.asList(keywords).contains(string)) {
                System.out.println("This is a KEYWORD");
            }
         else if(someInt!=null){
             System.out.println("This is an INTEGER");
         }

}
}