ListIterator<Order> it = orders.listIterator();

while ( it.hasNext() ) {
      Order ord = it.next();

      if ( ) // some condition
        it.remove(); // This wil remove the element that we just got using the next() method
      if ( ) // some other condition
        it.add(new Order()); // THis inserts the element immediately before the next call to next()
}