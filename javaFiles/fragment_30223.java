package com.company;
public class Main {    
    static String bunny = "bunny";    
    public static String subStringBunny (String bunny) {
        if (bunny.length() > 3) {
            bunny =  bunny.substring(2,4);
        }    
        return bunny;
    }

    public static void main(String[] args) {    
        System.out.println("this is substring from bunny: " + Main.subStringBunny(bunny));
    }
}