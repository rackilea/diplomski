package clothesshop;
import java.util.ArrayList;
public class Cart {
    private ArrayList<String> clothes = new ArrayList<String>(5);
    private ArrayList<Integer> costs = new ArrayList<Integer>(5);
    int cartAdd(String item, int price){//adding a certain item will be passed here
        clothes.add(item); 
        costs.add(price); 
        int TotalP=0;
        for (int total : costs) {
            TotalP = TotalP  + total; //total price
        }
        return TotalP;
    }

    void PrintRecipt() {
        for (int i=0; i<clothes.length; i++) { 
            System.out.println(clothes.get(i) + " at " + costs.get(i));
        }
    }  
}