for (Stock s : Arrays.asList(
        new Stock(1, "The Shawshank Redemption", 100, "DVD"), 
        new Stock(2, "Human Centipede", 123, "VHS"),
        new Stock(1, "Sharknado 2", 123, "Blu ray"))) {

    System.out.printf("%2d x %-30s (%-7s) %5.2f\n",
            s.getQuantity(), s.getName(), s.getType(),
            s.getPrice() * s.getQuantity());
}