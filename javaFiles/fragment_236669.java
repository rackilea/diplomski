public E pop() throws EmptyStructureException {
         if (isEmpty()) {
             throw new EmptyStructureException();
         }
         size--;
         return (E)data[size];
    }