Map<Integer, Product> products = new TreeMap<>();
try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(file))) {
    while (true) {
        Product product = (Product) input.readObject();
        products.put(product.getCode(), product); // Or whatever
    }
} catch (EOFException e) {
    // Just finish? Kinda nasty...
}