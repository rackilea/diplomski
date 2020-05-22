public static <T> T input(ProductFactory<T> factory, InputStream in) throws IOException {
    DataInputStream dataInputStream = new DataInputStream(in);
    String brand = dataInputStream.readUTF();
    String productName = dataInputStream.readUTF();
    BigDecimal price = new BigDecimal(dataInputStream.readUTF());
    int totalQuantity = dataInputStream.readInt();
    int defectiveQuantity = dataInputStream.readInt();
    List<Review> reviews = new ArrayList<>();
    for (Review review : reviews) {
        String userName = dataInputStream.readUTF();
        int rating = dataInputStream.readInt();
    }
    return factory.create(brand, productName, price, totalQuantity, defectiveQuantity, review);
}