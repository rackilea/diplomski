static class Pizza {
    String name;
    int price;

    public Pizza(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}