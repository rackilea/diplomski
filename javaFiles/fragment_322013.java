import java.io.*;
import java.util.*;

public class Sales extends addVideoGame implements java.io.Serializable{

    private static LinkedList<VideoGames> sellGame = new LinkedList<>();
    private static String searchTerm;
    private static int searchQ;

    public static void sellItem(){
        sellGame = games;
        int listLength = sellGame.size();
        searchTerm = IBIO.inputString("What item would you like to sell: ");
        boolean foundItem = false;
        for(VideoGames v : sellGame){
            if(v.getTitle().contains(searchTerm)){
                foundItem = true;
                IBIO.output("Item found: " + searchTerm);
                searchQ = v.getQuantity();
                IBIO.output("Available Quantity: " + searchQ);
                int sellQ = IBIO.inputInt("How much of this item would you like to sell: ");
                if(sellQ > searchQ){
                    IBIO.output("The amount you have specified is greater than the \ncurrent stock.");
                    sellItem();
                } else {
                    searchQ = searchQ - sellQ;
                    v.setQuantity(searchQ);
                    double sellP;
                    sellP = sellQ * v.getPrice();
                    IBIO.output("£"+sellP);
                    String confirm = IBIO.input("This is the price you are selling these items for. Type 'Yes' to complete the order or 'No' to reject it. ");
                    if(confirm.equalsIgnoreCase("Yes")){
                        IBIO.output("Order complete!");
                        try{
                            int receiptCount = 0;
                            PrintWriter receipt = new PrintWriter("C:\\Users\\Yemi\\Desktop\\TheStore\\receipt"+ receiptCount +".txt");
                            receipt.println("Item sold: " + v.getTitle());
                            receipt.println("Quantity sold: " + sellQ);
                            receipt.close();
                            receiptCount = receiptCount + 1;
                            IBIO.output("Receipt saved to: C:\\Users\\Yemi\\Desktop\\TheStore");
                        } catch(IOException io){
                            io.printStackTrace();
                        }
                        IBIO.output("Thank you for buying from Gamers Avenue UK!");
                    } else if(confirm.equalsIgnoreCase("No") && TheStore.privilege){
                        AccessMenus.adminMenu();
                    } else {
                        AccessMenus.userMenu();
                    }
                    if(TheStore.privilege){
                        AccessMenus.adminMenu();
                    } else {
                        AccessMenus.userMenu();
                    }
                }
                break;
            }
        }
        if(!foundItem) {
            IBIO.output("The item you are looking for does not exist.");
            sellItem();
        }
    }
}