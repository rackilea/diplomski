329:   /**
 330:    * Appends the supplied element to the end of this list.
 331:    * The element, e, can be an object of any type or null.
 332:    *
 333:    * @param e the element to be appended to this list
 334:    * @return true, the add will always succeed
 335:    */
 336:   public boolean add(E e)
 337:   {
 338:     modCount++;
 339:     if (size == data.length)
 340:       ensureCapacity(size + 1);
 341:     data[size++] = e;
 342:     return true;
 343:   }