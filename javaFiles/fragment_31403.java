public class Inventory {

    private ArrayList<String> inventoryItem = new ArrayList<>();

    public void addInventory(String item){
        inventoryItem.add(item);
    }

    public void displayInventory(){
        for (Sting item: inventoryItem) {
            if (item != null) {
                System.out.println(item + "\n");
            }
        }
    }
}