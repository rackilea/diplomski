ArrayList(Collection<? extends E> c) {
    elementData = c.toArray();
    size = elementData.length;
    // c.toArray might (incorrectly) not return Object[] (see 6260652)
    if (elementData.getClass() != Object[].class)
        elementData = Arrays.copyOf(elementData, size, Object[].class);
 }


public Object clone() {
    try {
        @SuppressWarnings("unchecked")
         ArrayList<E> v = (ArrayList<E>) super.clone();
         v.elementData = Arrays.copyOf(elementData, size);
         v.modCount = 0;
         return v;
     } catch (CloneNotSupportedException e) {
         // this shouldn't happen, since we are Cloneable
         throw new InternalError();
     }
 }