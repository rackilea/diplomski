class A <E> {  // class A has objects of E

    int x;

    private B<T> next // a object of inner class

    class B<T> implements Cloneable {
        public B<T> clone() {
           try {
              B<T> klon = (B<T>) super.clone();
              // TODO: maybe clone the array too?
              return klon;
           }
           catch(CloneNotSupportedException) {
              // should not occur
              throw new Error("programmer is stupid");
           }
        }
        // an inner class having objects of type T

        T[] elements = (T[]) Object[x];
        // has other stuff including many objects  
    }

 public A<E> func ( B<E> val ){
     B<E> clone = val.clone();
     // more code
 }