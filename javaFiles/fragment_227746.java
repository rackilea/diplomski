Producer p = new Producer(tooManyErrors, queue, poison);
Consumer c = new Consumer(tooManyErrors, queue, poison);
p.setConsumer(c);
c.setProducer(p);
new Thread(p).start();
new Thread(c).start();