Collections.sort(myList, new Comparator<Product>() {
       @Override
       public int compare(Product p0, Product p1) {
           return p0.getDate().compareTo(p1.getDate());
       }
});