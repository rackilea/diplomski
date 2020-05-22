224       public void addFirst(E e) {
  225           if (e == null)
  226               throw new NullPointerException();
  227           elements[head = (head - 1) & (elements.length - 1)] = e;
  228           if (head == tail)
  229               doubleCapacity();
  230       }


  312       /**
  313        * @throws NoSuchElementException {@inheritDoc}
  314        */
  315       public E getFirst() {
  316           E x = elements[head];
  317           if (x == null)
  318               throw new NoSuchElementException();
  319           return x;
  320       }