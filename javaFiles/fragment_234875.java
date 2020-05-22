public class TestOnBindings {

    private DoubleProperty price = new SimpleDoubleProperty(10.0);
    private DoubleProperty quantity = new SimpleDoubleProperty(1.0);
    private DoubleProperty total = new SimpleDoubleProperty(1.0);

    public TestOnBindings(){
        CustomBinding.<Number,Number>bindBidirectional(quantity, total, 
                (newQuantity)-> newQuantity.doubleValue() * price.get(),
                (newTotal)-> newTotal.doubleValue() /price.get());

        CustomBinding.<Number,Number>bind(price, total, 
                (newPrice)-> newPrice.doubleValue() * quantity.get());
    }

    public void setPrice(Double price){this.price.set(price);}
    public void setQuantity(Double quantity){this.quantity.set(quantity);}
    public void setTotal(Double total){this.total.set(total);}

    public Double getTotal(){return total.get();}
    public Double getQuantity(){return quantity.get();}
    public Double getPrice(){return price.get();}


    public static void main(String[] args) {
        TestOnBindings test = new TestOnBindings();

        test.setQuantity(5.0);

        System.out.println("Quantity = " + test.getQuantity());
        System.out.println("Price = " + test.getPrice());
        System.out.println("Total = " + test.getTotal());

        test.setTotal(60.0);

        System.out.println("---------------------------------------------");
        System.out.println("Quantity = " + test.getQuantity());
        System.out.println("Price = " + test.getPrice());
        System.out.println("Total = " + test.getTotal());

        test.setPrice(5.0);

        System.out.println("---------------------------------------------");
        System.out.println("Quantity = " + test.getQuantity());
        System.out.println("Price = " + test.getPrice());
        System.out.println("Total = " + test.getTotal());
    }

}