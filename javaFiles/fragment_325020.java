package com.sandbox;


import java.util.ArrayList;

public class Sandbox {

    public static void main(String[] args) {
        ArrayList<ArrayList<Double>> someArray = new ArrayList<ArrayList<Double>>();
        someArray.add(new ArrayList<Double>());
        someArray.get(0).add(5.5);
        someArray.get(0).add(6.5);
        someArray.add(new ArrayList<Double>());
        someArray.get(1).add(2.5);
        someArray.get(1).add(3.5);
        someArray.get(1).add(4.5);
        someArray.add(new ArrayList<Double>());
        someArray.get(2).add(2.5);

        boolean elementsLeft = true;
        int column = 0;
        while (elementsLeft) {
            for (ArrayList<Double> subList : someArray) {
                if (subList.size() > column) {
                    System.out.print(subList.get(column) + " ");
                }else {
                    System.out.print("x ");
                }
            }
            System.out.println();

            elementsLeft = isElementsLeft(someArray, column);
            column++;
        }
    }

    private static boolean isElementsLeft(ArrayList<ArrayList<Double>> someArray, int column) {
        for (ArrayList<Double> subList : someArray) {
            if (subList.size() > column) {
                return true;
            }
        }
        return false;
    }
}