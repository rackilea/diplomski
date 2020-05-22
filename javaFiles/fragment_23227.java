long sequence = ringBuffer.next();
  try {
  Event e = ringBuffer.get(sequence);
  // Do some work with the event.
} finally {
  ringBuffer.publish(sequence);
}