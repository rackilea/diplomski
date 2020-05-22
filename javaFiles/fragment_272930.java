CyclicQueue(int size) {
  queues = new Queue[size];

  for(int i=0; i<size; i++)
    queues[i] = new LinkedList<T>();
}

T get() {
  int i = current;
  T value;
  while( (value = queues[i].poll() == null) {
    i++;
    if(i == current)
      return null;
  }
  return value;
}