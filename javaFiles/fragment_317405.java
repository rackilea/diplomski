ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<String>();
String s = new String("hi");
MemorySampler.start();
queue.offer(s);
MemorySampler.end();
if (MemorySampler.wasMemoryAllocated()) MemorySampler.printSituation();