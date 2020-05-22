package tst;

import java.util.Scanner;

public class learningObjectsAndClasses {
public static void main(String args[]){

    Scanner input = new Scanner(System.in);

    System.out.println("Enter Month Name ");
    String monthName = input.next();
    Monthnum inputMonthNumber = new Monthnum(monthName);

    System.out.println("Enter Number ");
    int monthNumber = input.nextInt();
    Monthnum inputMonthName = new Monthnum(monthNumber);

}
public static class Monthnum{

    public int Monthnum;
    public String monthName;


    public Monthnum(){
        Monthnum = 1;
        monthName = "January";
    }
    public Monthnum(int whichMonth){
        Monthnum = whichMonth;
        if (whichMonth == 1){
            monthName = "January";
            System.out.println("January");
        }
        else if (whichMonth == 2){
            monthName = "February";
            System.out.println("February");
        }
        else if (whichMonth == 3){
            monthName = "March";
            System.out.println("March");
        }
        else if (whichMonth == 4){
            monthName = "April";
            System.out.println("April");
        }
        else if (whichMonth == 5){
            monthName = "May";
            System.out.println("May");
        }
        else if (whichMonth == 6){
            monthName = "June";
            System.out.println("June");
        }
        else if (whichMonth == 7){
            monthName = "July";
            System.out.println("July");
        }
        else if (whichMonth == 8){
            monthName = "August";
            System.out.println("August");
        }
        else if (whichMonth == 9){
            monthName = "September";
            System.out.println("September");
        }
        else if (whichMonth == 10){
            monthName = "October";
            System.out.println("October");
        }
        else if (whichMonth == 11){
            monthName = "November";
            System.out.println("November");
        }
        else if (whichMonth == 12){
            monthName = "December";
            System.out.println("December");
        }
        else {
            System.out.println("Invalid input from int cons");
        }

    } //end of cons

    public Monthnum(String whichMonth){
        if (whichMonth.equals("January")){
            Monthnum = 1;
            System.out.println(Monthnum);
        }
        else if (whichMonth.equals("February")){
            Monthnum = 2;
            System.out.println(Monthnum);
        }
        else if (whichMonth.equals("March")){
            Monthnum = 3;
            System.out.println(Monthnum);
        }
        else if (whichMonth.equals("April")){
            Monthnum = 4;
            System.out.println(Monthnum);
        }
        else if (whichMonth.equals("May")){
            Monthnum = 5;
            System.out.println(Monthnum);
        }
        else if (whichMonth.equals("June")){
            Monthnum = 6;
            System.out.println(Monthnum);
        }
        else if (whichMonth.equals("July")){
            Monthnum = 7;
            System.out.println(Monthnum);
        }
        else if (whichMonth.equals("August")){
            Monthnum = 8;
            System.out.println(Monthnum);
        }
        else if (whichMonth.equals("September")){
            Monthnum = 9;
            System.out.println(Monthnum);
        }
        else if (whichMonth.equals("October")){
            Monthnum = 10;
            System.out.println(Monthnum);
        }
        else if (whichMonth.equals("November")){
            Monthnum = 11;
            System.out.println(Monthnum);
        }
        else if (whichMonth.equals("December")){
            Monthnum = 12;
            System.out.println(Monthnum );
        }
        else
            System.out.println("Invalid input");
    }
  }
}