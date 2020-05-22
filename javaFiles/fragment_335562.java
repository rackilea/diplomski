import java.util.Scanner;

public class Main {
private static String[][] letterList;

public static void main(String[] args) {
    letterList=new String[4][4];

    System.out.println("Enter any letter combo of T, I, or L");
    Scanner scanner=new Scanner(System.in);
    String input=scanner.nextLine();

    char[] charArray=input.toCharArray();
    int letterPos=0;

    for(char c: charArray) { 
        assignLetter(c,letterPos);
        letterPos++;
    }
    print();
}


public static void assignLetter(char c, int letterPos) {
    switch (c) {
    case 'T':
        addT(letterPos);
        break;
    case 'I':
        addI(letterPos);
        break;
    case 'L':
        addL(letterPos);
        break;
    }
}


public static void addT(int letterPos){
    letterList[0][letterPos]="-------";
    letterList[1][letterPos]="   |   ";
    letterList[2][letterPos]="   |   ";
    letterList[3][letterPos]="   |   ";
}

public static void addI(int letterPos){
    letterList[0][letterPos]=" | ";
    letterList[1][letterPos]=" | ";
    letterList[2][letterPos]=" | ";
    letterList[3][letterPos]=" | ";
}

public static void addL(int letterPos){
    letterList[0][letterPos]="|     ";
    letterList[1][letterPos]="|     ";
    letterList[2][letterPos]="|     ";
    letterList[3][letterPos]="|---- ";
}

private static void print() {
    for (int i=0; i<=3; i++) {
        System.out.println();
        for (int j=0; j<=3; j++) {
            System.out.print(letterList[i][j]);
        }
    }
}