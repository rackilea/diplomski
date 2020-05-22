public static void main(String[] args) {
  Product p1 = new Product("Apple", "10.5", "USD", "MacBook");
  Product p2 = new Product("NOKIA", "12.5", "USD", "PHONE");
  ArrayList<Product> a = new ArrayList<>();
  a.add(p1);
  a.add(p2);
  ProdsList l = new ProdsList(a);

  marshal(l, System.out);
}