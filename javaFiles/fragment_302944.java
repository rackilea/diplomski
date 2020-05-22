@Override
public void remove() throws QueueUnderflowException {
    if (isEmpty()) {
        throw new QueueUnderflowException();
    } else {
        int priority = 0;
        int largeIndex = 0;
        for (int i = 0; i < tailIndex; i++) {
          if (((PriorityItem<T>) storage[i]).getPriority() > priority) {
            priority = ((PriorityItem<T>) storage[i]).getPriority();
            largeIndex = i ;
          }
        }

        for(int i = largeIndex; i < (tailIndex - 1) ; i++)
          storage[i] = storage[i + 1];
    }
    tailIndex = tailIndex - 1;
  }