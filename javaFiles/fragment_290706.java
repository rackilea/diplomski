import java.util.Scanner;

class DNA {    
public static void main(String[] args) 
{
    System.out.println("Please input a DNA sequence: ");

    Scanner read = new Scanner(System.in);
    String input = read.next();               

    String reverse="";
    StringBuilder sb = new StringBuilder();
    for(int i = input.length() - 1; i >= 0; i--) {
        reverse = reverse + input.charAt(i);
    }
    for (char c: input.toCharArray()) {  // user 'reverse' to operate on reversed string
        switch (c) {
            case 'A' : sb.append('T'); break;
            case 'T' : sb.append('A'); break;
            case 'G' : sb.append('C'); break;
            case 'C' : sb.append('G'); break;
            default : sb.append(""); break; // handle you're exceptions here
        }
    }
    System.out.println("x: " + sb);

    System.out.println("Here is the reversed sequence: ");
    System.out.println(reverse);

    read.close();
}}