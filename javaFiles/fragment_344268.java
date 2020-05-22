public int visit(Book b) {
     return b.getPrice();
}

public int visit(Fruit f) {
     return f.getPricePerKg()*f.getWeight();
}