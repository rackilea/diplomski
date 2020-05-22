package com.org.test;
import java.util.Scanner;


public class rough{
public static void main(String args[]){
            int number = 0;
            Scanner scanner = new Scanner(System.in);
            System.out.print("Please type a number between 0 and 999 OR type -1 to exit:  ");
            number = scanner.nextInt();
            while(number!=-1){
                if(number>=0 && number<=999){
                    if(number==0){
                        System.out.print("ZERO");
                    } else if(number==100||number==200||number==300||number==400||number==500||number==600||number==700||number==800||number==900){
                           hundred(number);
                    }else if(number==20||number==30||number==40||number==50||number==60||number==70||number==80||number==90){
                           tens(number);
                    }else if(number>=101){
                           From101(number);
                    }else if(number >=1 && number<=99){ // checking for numbers which are less then 99.
                        if(number >=1 && number <=19){
                            from1To19(number);
                        }else{
                            twoDigitNumber(number);  // added new method that call two digit number 
                        }
                    }

                } else{
                    System.out.print("NUMBER OUT OF RANGE");
                }
                System.out.print("\nPlease type a number between 0 and 999 OR type -1 to exit:  ");
                number = scanner.nextInt();
            }
        }



        public static void hundred(int num){
        String HUNDREDS[] = {" ", "ONE HUNDRED", "TWO HUNDRED", "THREE HUNDRED", "FOUR HUNDRED", "FIVE HUNDRED", "SIX HUNDRED", "SEVEN HUNDRED", "EIGHT HUNDRED", "NINE HUNDRED"};
        if(num>=100){
        int ArrayOrder = num/100;
        System.out.print(HUNDREDS[ArrayOrder]);  // add print statement not println
        }else{
         System.out.print(HUNDREDS[num]);  // add print statement not println
      }
    }

    public static void tens(int num){
    String TENS[] = {" ", " ", " TWENTY", " THIRTY", " FOURTY", " FIFTY", " SIXTY", " SEVENTY", " EIGHTY", " NINETY"};
    if(num >=20){
        int ArrayOrder = num/10;
        System.out.print(TENS[ArrayOrder]);  // add print statement not println
    }else{
        System.out.print(TENS[num]);   // add print statement not println
    }
    }

    public static void from1To19(int num){
    String ONES[] = {" ", " ONE", " TWO", " THREE", " FOUR", " FIVE", " SIX", " SEVEN", " EIGHT", " NINE", " TEN", " ELEVEN", " TWELVE", " THIRTEEN", " FOURTEEN", " FIFTEEN", " SIXTEEN", " SEVENTEEN", " EIGHTEEN", " NINETEEN"};
    System.out.println(ONES[num]);
    }

    public static void twoDigitNumber(int num){
        String ONES[] = {" ", " ONE", " TWO", " THREE", " FOUR", " FIVE", " SIX", " SEVEN", " EIGHT", " NINE", " TEN"};
        String PRO[] = {"",""," TWENTY", "THRTY", "FOURTY", " FIFTY", " SIXTY", " SEVENTY", " EIGHTY", " NINETY"};


        System.out.print(PRO[(num/10)]);
        System.out.print(ONES[(num%10)]);
        }


    public static void From101(int num){
        int first = num%10;//  find the first number
        num = num;//##
        int second = (num/10)%10;// find second number
        num = num;//#
        hundred(num); tens(second); from1To19(first);
    }  
}