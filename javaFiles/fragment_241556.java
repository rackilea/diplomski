AtomicInteger i1 = new AtomicInteger(11);
AtomicInteger i2 ;
i2 = i1;
System.out.println(i1+"   "+i2);
i1.set(233);
System.out.println(i1+"   "+i2);