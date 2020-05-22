for (Iterator<Fruit> iter = list.listIterator(); iter.hasNext(); ) {
    Fruit f = iter.next();
    if (f.getColor().equalsIgnoreCase("red")) {
        iter.remove();
    }
}