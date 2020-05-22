public class MyRestaurantTester {

    public static void main(String[] args) {
        Date currentDate = new Date();
        Paraggelia order1 = new Paraggelia(currentDate,"11B");
        Product Beer = new Product("Amstel","111222",1.20f);
        Product Beef = new Product("Pork Beef","333444",8.50f);

        order1.add(Beer, 1);
        order1.add(Beef, 5);
        System.out.println(order1.getReceipt(30f));

    }

}