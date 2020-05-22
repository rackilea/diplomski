import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;


class Item implements Serializable{
    String name;
    String description;
    float price;

    public Item(String name, String description, float price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public float getPrice() {
        return price;
    }
    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Item [name=" + name + ", description=" + description
                + ", price=" + price + "]";
    }

    public String itemInfo() {
        return toString();
    }

    public String viewitem() {
        return toString();
    }
}

public class FileReader {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        HashMap<Integer, Item> items = readItems();
        Set<Integer> keys = items.keySet();
        while (true) {
        boolean exist = true;
        lineBreak(12, " -");
        System.out.println("|***ITEM  MANAGEMENT***|");
        System.out.println("|  [1] - Add Item      |");
        System.out.println("|  [2] - Delete Item   |");
        System.out.println("|  [3] - Edit Item     |");
        System.out.println("|  [4] - List All Items|");
        System.out.println("|  [5] - View Item     |");
        System.out.println("|  [6] - Save          |");
        System.out.println("|  [7] - Exit          |");
        lineBreak(12, " -");
        System.out.print("Enter your choice>> ");
        int choice = s.nextInt();
        int id;
        String name, des;
        float price;
        Item i;
        switch (choice) {
            case 1:
            System.out.print("INPUT ID: ");
            id = s.nextInt();
            if(items.containsKey(id) == exist){System.out.println("This id already exist");
            exist = false;
            break;
            }
            if(exist == true){
            s.nextLine(); //trap
            System.out.print("INPUT NAME: ");
            name = s.nextLine();
            System.out.print("INPUT DESCRIPTION: ");
            des = s.nextLine();
            System.out.print("INPUT PRICE: ");
            price = s.nextFloat();
            i = new Item(name, des, price);
            items.put(id, i);
            }
            break;
            case 2:
            System.out.println("ENTER ID: ");
            id = s.nextInt();
            if (items.get(id) == null) {
                System.out.println("This id does not exist\n");
            } else {
                items.remove(id);
            }
            break;
            case 3:
            System.out.println("ENTER ID: ");
            id = s.nextInt();
            if (items.get(id) == null) {
                System.out.println("This id does not exist");
            } else {
                s.nextLine(); //trap
                System.out.print("INPUT NEW NAME: ");
                name = s.nextLine();
                System.out.print("INPUT NEW DESCRIPTION: ");
                des = s.nextLine();
                System.out.print("INPUT NEW PRICE: ");
                price = s.nextFloat();
                i = new Item(name, des, price);
                items.replace(id, i);
            }
            break;
            case 4:
            System.out.printf("%-15s%-8s%15s\n", "ID", "NAME", "PRICE");
            lineBreak(19, " -");
            if (items.isEmpty()) {
                System.out.printf("\n%-12s%-15s%15s\n\n", "", "NORECORDSTOSHOW", "");
            } else {
                for (int key : keys) {
                System.out.printf("%-15d%15s\n", key, items.get(key).itemInfo());
                }
                System.out.println();
            }
            break;
            case 5:
            System.out.println("ENTER ID: ");
            id = s.nextInt();
            if (items.get(id) == null) {
                System.out.println("This id does not exist\n");
            } else {
                System.out.printf("%-15s%-15s%-15s%15s\n", "ID", "NAME", "DESCRIPTION", "PRICE");
                System.out.printf("%-15d%15s\n\n", id, items.get(id).viewitem());
            }
            break;
            case 6:
            String file ="c:\\prespres.txt";
                try {
                    FileOutputStream fos = new FileOutputStream(file);
                    ObjectOutputStream oos = new ObjectOutputStream(fos);
                    oos.writeObject(items);
                    oos.close();
                    fos.close();
                    System.out.println("SAVED!");
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(FileReader.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(FileReader.class.getName()).log(Level.SEVERE, null, ex);
                }
            break;
            case 7:
            System.exit(1);
            default:
            System.out.println("Invalid Input!\n");
        }
        }
    }

    private static HashMap<Integer, Item> readItems() {
        HashMap<Integer, Item> items = null;
        try {
            FileInputStream fin = new FileInputStream("c:\\prespres.txt");
            ObjectInputStream ois = new ObjectInputStream(fin);
            items = (HashMap<Integer, Item>) ois.readObject();
            ois.close();
        } catch (Exception ex) {}
        return (items == null) ? new HashMap<>() : items;
    }

    private static void lineBreak(int i, String string) {

    }

}