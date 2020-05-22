public class Item implements Comparable<Item> {
    private Integer itemNo;
    private String itemName;
    private String itemDescription;

    public int compareTo(Item o) {
        return o.itemName.compareTo(itemName); // Note reverse of normal order
    }

    // rest of class
}