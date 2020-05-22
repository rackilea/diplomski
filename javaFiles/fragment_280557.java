import java.util.Arrays;

public class HelloWorld {

     public static void main(String []args){
        String[] name = {"Alix", "Jack", "Alexis", "Adam", "John", "Lexi", 
             "George", "Gregory", "Paul", "Bjorn", "Aaron", "Joseph", "Anderson"};

        int splitArrayForSize = 3; 

        for(int i=0; i< name.length; i+=splitArrayForSize){

            String[] subArray = Arrays.copyOfRange(name, i, 
                                        Math.min(name.length, i + splitArrayForSize));

            String subArrayAsString = Arrays.toString(subArray);
            System.out.println(subArrayAsString);   
        }  
    }
}