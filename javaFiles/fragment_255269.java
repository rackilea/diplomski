public class GroceryList {



List<GroceryItem> list = null;  
int num;  

public GroceryList() {  

    list = new ArrayList<GroceryItem>();  
    this.num = 0;  

}  

// Constructs a new empty grocery list.  

   public void add(GroceryItem item) {  
    list.add(item);  
   System.out.println("Added Grocery :::: >>>> NAME:" +item.getName()+ " :::::  PRICE PER UNIT: "+item.getPricePerUnit()+" :::::: QUANTITY: "+item.getQuantity()+" ::::: FINALCOST: "+(item.getQuantity()*item.getPricePerUnit()) );}


// Adds the given item order to this list, if the list is not full (has  
// fewer than 10 items).  
 public double getTotalCost() {  
    double totalcost = 0;  
    for(int i = 0; i < list.size(); i++){  
    totalcost += list.get(i).getCost();  
    }  

    return totalcost;  
}  
// Returns the total sum cost of all grocery item orders in this list.  
}  


    /// Add this function as toString class

    @Override
        public String toString() {
            return "GroceryList [list=" + list + ", num=" + num + "]";
        }