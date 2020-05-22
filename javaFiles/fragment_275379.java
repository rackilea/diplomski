package myCollege;

import java.util.ArrayList;
import myLibrary.Book;
import myLibrary.Disk;
import myLibrary.Item;
import myLibrary.Magazine;
import myLibrary.Paper;

public class Lecturer {

    public static void main(String[] args) {

        // Declare items
        Book x1 = new Book("Item101");
        Book x2 = new Book("Item102");
        Disk x3 = new Disk("Item201");
        Disk x4 = new Disk("Item202");
        Magazine x5 = new Magazine("Item301");
        Paper x6 = new Paper("Item401");
        Paper x7 = new Paper("Item402");

        ArrayList<Item> items = new ArrayList<>();
        items.add(x1);
        items.add(x2);
        items.add(x3);
        items.add(x4);
        items.add(x5);
        items.add(x6);
        items.add(x7);

        String itemType = getItemByBarcode("Item202", items);
        System.out.println(itemType);


    }

    private static String getItemByBarcode(String barcode, ArrayList<Item> items) {
        String itemType = "";
        for(Item i : items) {
            if(i.getBarcode().equalsIgnoreCase(barcode)) {
                itemType = i.getClass().getSimpleName();                
            }
        }
        return itemType;
    }

}