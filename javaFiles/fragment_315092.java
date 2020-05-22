final Comparator<Order> quantityAsc = new Comparator<Order>() {
   public int compare(Order o1, Order o2) {
      return o2.quantity - o1.quantity; // smaller order comes before bigger one
   }
}

final Comparator<Order> productDesc = new Comparator<Order>() {
   public int compare(Order o1, Order o2) {
      if (o2.productName == null) {
         return o1.productName == null ? 0 : -1;
      }
      return o2.productName.compareTo(o1.productName);
   }
}

final List<Order> orders = ...; // populated by parsing the CSV

final List<Order> ordersByQuantity = Collections.sort(orders, quantityAsc);
final List<Order> ordersByProductZToA = Collections.sort(orders, productDesc);