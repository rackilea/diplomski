// Receiver
TreeSet<Message> cache = new TreeSet<>(new OrderMessagesByIndexComparator());
Message message;
while(run) {
  message = receive();
  cache.add(message);
  Iterator<Message> it = cache.iterator();
  while(it.hasNext()) {
    Message m = it.next();
    if(m.index == next) {
      next++;
      it.remove();
      queue.add(m);
    } else {
      break;
    }
  }
}

// Message consumer
while(run) {
  message = queue.take();
}