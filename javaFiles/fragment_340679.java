Conc target = new Conc ();
  Thread t1 = new Thread(target);
  Thread t2 = new Thread(target);
  Thread t3 = new Thread(target);
  t1.start();
  t2.start();
  t3.start();