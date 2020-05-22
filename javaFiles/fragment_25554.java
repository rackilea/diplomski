public class Player {

    private String name;
    private List<Item> inventory;
    private int items;

    public Player() {
        this.inventory = new ArrayList();
    }

    public void addItem(String itemName, int itemType) {
        this.inventory.add(new Item(itemName, itemType));
    }

    public void removeItem(int x) {
        Item itemToRemove = this.inventory.get(x);
        if (itemToRemove != null) {
            this.inventory.remove(itemToRemove);
        }
    }

    public static void main(String[] args) {
        // create a new instance
        Player player = new Player();
        // call a method on the instance
        player.addItem("bla", 0);
    }
}