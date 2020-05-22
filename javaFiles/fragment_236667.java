public E peek() throws EmptyStructureException {
        if (isEmpty()) {
          throw new EmptyStructureException();
        }
        return (E)data[size - 1];
    }