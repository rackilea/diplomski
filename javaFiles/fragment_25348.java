public class FlavoredBaguette extends Baguette {
    //String name;
    //int price;
    String flavor;
    int costFlav;

    public FlavoredBaguette(String name, int price, String flavor, int costFlav) 
    {
        super(name, price);
        //this.name = name; 
        //this.price = price; 
        this.flavor = flavor;
        this.costFlav = costFlav;
    }
}