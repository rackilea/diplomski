package com.stackover.ex;


public class TwoRockets {

    public static void main (String[] args) {

        appearrocket();     
        //appearrocket();

    }



    public static void appearrocket() {

        cone();
        box();
        label();
        box();
        cone();     
    }



    public static void box() {

        System.out.println("+------+\t"+"+------+");
        System.out.println("|      |\t"+"|      |");
        System.out.println("|      |\t"+"|      |");
        System.out.println("+------+\t"+"+------+");

    }

    public static void cone() {

        System.out.println("   /\\\t\t"+"   /\\");
        System.out.println("  /  \\\t\t"+"  /  \\");
        System.out.println(" /    \\\t\t"+" /    \\");      
    }

    public static void label() {

        System.out.println("| VIVA |\t"+"| VIVA |");
        System.out.println("|MEXICO|\t"+"|MEXICO|");
    }
}