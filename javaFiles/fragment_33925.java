public class ProductDups {

    public static void main(String[] args) {

        List<Product> productsList = new ArrayList<>();
        productsList.add(new Product("000123000", "456"));
        productsList.add(new Product("000123001", "456"));
        productsList.add(new Product("000124003", "567"));
        productsList.add(new Product("000124002", "567"));

        List<Product> minDuplicates = productsList.stream()
                .collect(
                        Collectors.toMap(
                                p -> Arrays.asList(p.getB(),
                                        p.getA().substring(3, p.getA().length() - 3)),
                                p -> {
                                    TreeSet<Product> ts = new TreeSet<>(Comparator.comparing(Product::getA));
                                    ts.addAll(Arrays.asList(p));
                                    return ts;
                                },
                                (a, b) -> {
                                    a.addAll(b);
                                    return a;
                                }
                        )
                )
                .entrySet()
                .stream()
                .filter(e -> e.getValue().size() > 1)
                .map(e -> e.getValue().first())
                .collect(Collectors.toList());
        System.out.println(minDuplicates);

    }
}
class Product {

    String a;
    String b;

    public Product(String a, String b) {
        this.a = a;
        this.b = b;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    @Override
    public String toString() {
        return "Product{" +
                "a='" + a + '\'' +
                ", b='" + b + '\'' +
                '}';
    }
}