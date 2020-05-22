public class Example {
    public static void main(String[] args) {
        ItemRegistry reg = new ItemRegistry();
        reg.registerItem(new RegularItem("Toy Gun", 10));
        reg.registerItem(new ItemDiscount(new RegularItem("Toy Car", 100), 10));  // apply 10% discount to Toy Car item

        for(Item item : reg.getItems()) {
            System.out.println("Name: " + item.getName());
            System.out.println("Cost: " + item.getCost());
        }
        System.out.println("Total: " + reg.getTotalCost());
    }
}