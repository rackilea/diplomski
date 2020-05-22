import java.io.*;
 import java.util.Scanner;
 import java.util.StringTokenizer;
 public class knn {
 public static void main (String[]args)throws IOException{
    Scanner in = new Scanner(new FileInputStream("knn.txt"));

    while(in.hasNextLine()){
        String linetoprocess = in.nextLine();
        StringTokenizer st = new StringTokenizer(linetoprocess, " :");
        Scanner in2 = new Scanner(new FileInputStream("knn2.txt"));
        String a = st.nextToken();
        String b = st.nextToken();
        String c = st.nextToken();
        String d = st.nextToken();
        String e = st.nextToken();
        String f = st.nextToken();
        String g = st.nextToken();
        String h = st.nextToken();
        String i = st.nextToken();

        while(in2.hasNextLine()){
        String linetoprocess2 = in2.nextLine();
        StringTokenizer st2 = new StringTokenizer(linetoprocess2, " :");
        System.out.print("("+a+","+st2.nextToken()+"), ");
        System.out.print("("+b+","+st2.nextToken()+"), ");
        System.out.print("("+c+","+st2.nextToken()+"), ");
        System.out.print("("+d+","+st2.nextToken()+"), ");
        System.out.print("("+e+","+st2.nextToken()+"), ");
        System.out.print("("+f+","+st2.nextToken()+"), ");
        System.out.print("("+g+","+st2.nextToken()+"), ");
        System.out.print("("+h+","+st2.nextToken()+"), ");
        System.out.println("("+i+","+st2.nextToken()+")");

        }
    }
}