public class Main {

    public static void main(String[] args) {
        new Main().go();
    }

    public void go() {
        Product p1 = new Product();
        p1.setName("P1");
        p1.setPrice(2.5);
        p1.setQuantity(1);

        Product p2 = new Product();
        p2.setName("P2");
        p2.setPrice(5.3);
        p2.setQuantity(1);

        Set<Product> products = new HashSet<Product>();
        products.add(p1);
        products.add(p2);

        System.out.println(products);

        // now let's assume that you want to change quantity of P1

        Product newp1 = new Product();
        newp1.setName("P1");
        newp1.setPrice(2.5);
        newp1.setQuantity(2);

        if (products.contains(newp1)) {
            products.remove(newp1);
        }
        products.add(newp1);

        System.out.println("after update:");
        System.out.println(products);
    }

}