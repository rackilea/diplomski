import java.io.*;
import java.util.*;
public class MyClass {
    public static void main(String args[]) throws IOException{
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        // Split is a String function that uses regular function to split a string, 
        // apparently you can strings like a space given above, the regular expression 
        // for space is \\s or \\s+ for multiple spaces
        int max = 0;
        for(int i=0;i<s.length;i++) max = Math.max(max,s[i].length()); // Finds the string having maximum length
        int count = 0;
        while(count<max){ // iterate till the longest string exhausts
            for(int i=0;i<s.length;i++){
                if(count<s[i].length()) System.out.print(s[i].charAt(count)+" "); // exists print the character
                else System.out.print("  "); // Two spaces otherwise
            }
            System.out.println();count++;
        }
    }
}