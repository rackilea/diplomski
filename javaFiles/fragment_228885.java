public boolean equals(Object o) {
      if (o == this) //Equality check
          return true;
      if (!(o instanceof List))  //Type check
          return false;
      ListIterator<E> e1 = listIterator();
      ListIterator e2 = ((List) o).listIterator();
      while(e1.hasNext() && e2.hasNext()) {
          E o1 = e1.next();
          Object o2 = e2.next();
          if (!(o1==null ? o2==null : o1.equals(o2))) //equality check of list contents
              return false;
      }
      return !(e1.hasNext() || e2.hasNext());
  }