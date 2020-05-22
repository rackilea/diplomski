/** array on which the list is based */
private final Vector<E> items=new Vector<E>();    

/** default Constructor */
public ListVectorBased() {      
}

/** constructor with the first item: constructs a list with the
 * specified item as single element of this list
 * @param item first element of the list
 */
public ListVectorBased(E elt) {
    items.add(elt);
}

/** copy constructor: create a duplicate of the specified list
 * @param list to be copied
 */
public ListVectorBased(Vector<E> items) {
    this.items.addAll(items);
}