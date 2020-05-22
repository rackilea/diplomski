public class Item {
    public static ArrayList<String> type_list = new ArrayList<>();
    public static ArrayList<String> name_list = new ArrayList<>();
    public static ArrayList<Double> price_list = new ArrayList<>();
    public static ArrayList<Integer> qty_list = new ArrayList<>();

    public String type;
    public String name;
    public Double price;
    public Integer qty;

    public Item (String type, String name, Double price, Integer qty){
        this.type = type;
        this.name = name;
        this.price = price;
        this.qty = qty;
    }
}