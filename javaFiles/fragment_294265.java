package com.company;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;

public class StatsPrinter {
    private static DecimalFormat format = new DecimalFormat("#.##");

    public static void printStatistics(HashMap<String, List<ShoppingEntry>> shoppingList) {
        printNuumberOfItems(shoppingList);
        printLargestValue(shoppingList);
        printLargestAverage(shoppingList);
    }

    private static void printNuumberOfItems(HashMap<String, List<ShoppingEntry>> shoppingList) {
         System.out.println("There are " + shoppingList.keySet().size() + " items in your Shopping List");
     }

    private static void printLargestValue(HashMap<String, List<ShoppingEntry>> shoppingList) {
        double currentLargestPrice = 0;
        String largestPriceCategory = new String();

        for(String keyValue : shoppingList.keySet()) {
            for(ShoppingEntry entry : shoppingList.get(keyValue)) {
                if (entry.getPrice() > currentLargestPrice) {
                    currentLargestPrice = entry.getPrice();
                    largestPriceCategory = keyValue;
                }
            }
        }

        System.out.println(largestPriceCategory + " has the largest value of: " +      format.format(currentLargestPrice));
     }

    private static void printLargestAverage(HashMap<String, List<ShoppingEntry>> shoppingList) {
        double currentLargestAverage = 0;
        String largestAverageCategory = new String();
        double totalCost = 0;
        int numberOfItems = 0;

        for(String keyValue : shoppingList.keySet()) {
            for(ShoppingEntry entry : shoppingList.get(keyValue)) {
                totalCost += entry.getPrice();
                numberOfItems += entry.getQuantity();
            }
            if((totalCost / numberOfItems) > currentLargestAverage) {
                currentLargestAverage = totalCost / numberOfItems;
                largestAverageCategory = keyValue;
            }
        }

        System.out.println(largestAverageCategory + " has the largest average value of: " +     format.format(currentLargestAverage));
    }
}