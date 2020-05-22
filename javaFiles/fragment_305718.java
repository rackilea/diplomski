import java.util.*;

public class Trip {

    /** An item in the expanses list */
    static class Item {
        final String item;
        final int cost;
        public Item(String item, int cost) {
            this.item = item;
            this.cost = cost;
        }
        @Override public String toString() {
            return this.item + " (" + this.cost + "$)";
        }
    }

    /** A map with category as key and the associed list of items as value */
    Map<String,List<Item>> expanses;


    public Trip() {
        this.expanses = new HashMap<String,List<Item>>();
        String[] categories = {"food","clothes","souvenir"};
        for (String cat: categories) { // init the categories with empty lists
            this.expanses.put(cat, new ArrayList<Item>());
        }
    }



    /** Register a new expanse to the trip. */
    public void add(String item, int cost, String category) {
        List<Item> list = this.expanses.get(category);
        if (list == null)
            throw new IllegalArgumentException("Category '"+category+"' does not exist.");
        list.add( new Item(item, cost) );
    }

    /** Get the expanses, given a category.
     * @return  a fresh ArrayList containing the category elements, or null if the category does not exists
     */
    public List<Item> getItems(String category) {
        List<Item> list = this.expanses.get(category);
        if (list == null)
            return null;
        return new ArrayList<Item>(list);
    }

    /** Get the expanses, given a category.
     * @return  a fresh ArrayList containing all the elements
     */
    public List<Item> getItems() {
        List<Item> list = new ArrayList<Item>();
        for (List<Item> l: this.expanses.values()) // fill with each category items
            list.addAll(l);
        return list;
    }

    /** Get the total cost, given a category. */
    public int getCost(String category) {
        List<Item> list = this.expanses.get(category);
        if (list == null)
            return -1;
        int cost = 0;
        for (Item item: list)
            cost += item.cost;
        return cost;
    }

    /** Get the total cost. */
    public int getCost() {
        int cost = 0;
        for (List<Item> l: this.expanses.values())
            for (Item item: l)
                cost += item.cost;
        return cost;
    }


    // lets test this structure
    public static void main(String[] args) {

        Trip trip1 = new Trip();

        trip1.add("apple", 10, "food");
        trip1.add("cheese", 15, "food");
        trip1.add("hat", 30, "clothes");


        System.out.println( trip1.getItems("food") );
        System.out.println( trip1.getCost("food") );
        System.out.println();
        System.out.println( trip1.getItems() );
        System.out.println( trip1.getCost() );

    }

}