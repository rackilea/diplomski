import java.util.Scanner;

public class DecreaseLetters {

public static void main(String args[]){

Scanner s=new Scanner(System.in);

System.out.println("Anota una Frase: ");
String str=s.nextLine();
while(str.length()>1) {
    str =  str.substring(0,str.length()-1);     
    System.out.println(str.substring(0,str.length()-1));
     }

   }
}