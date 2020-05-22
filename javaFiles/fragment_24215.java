735 
736     public Iterator<E> More ...iterator() {
737         return new Itr();
738     }


An optimized version of AbstractList.Itr
742 
743     private class More ...Itr implements Iterator<E> {
744         int cursor;       // index of next element to return