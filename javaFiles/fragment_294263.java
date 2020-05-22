package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        String category;
        String quantity;
        String value;

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, List<ShoppingEntry>> shoppingList = new HashMap<String, List<ShoppingEntry>>();

        while(true) {
            System.out.print("Enter the category of your item: ");
            category = bufferedReader.readLine();

            if("end".equals(category)){
                break;
            }

            System.out.print("Enter the quantity of your item: ");
            quantity = bufferedReader.readLine();

            System.out.print("Enter the value of your item: ");
            value = bufferedReader.readLine();

            if (shoppingList.containsKey(category)) {
                shoppingList.get(category).add(new ShoppingEntry(Integer.parseInt(quantity), Double.parseDouble(value)));
            }else{
                shoppingList.put(category, new ArrayList<ShoppingEntry>());
                shoppingList.get(category).add(new ShoppingEntry(Integer.parseInt(quantity),          Double.parseDouble(value)));
            }
        }

        StatsPrinter.printStatistics(shoppingList);
    }
}