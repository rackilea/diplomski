int i = 0;
  List<Customer>customers = customer.getCustomers();
  CountDownLatch cdl =new CountDownLatch(customers.size());      // new code 
  long startTimestamp = System.currentTimeMillis();

   for (Customer c: customers){
      new RequestProcessor(cdl,c, i).start();
      i++;
    }

   cdl.await();                                                      // new code . 
  // the thread will hang up unitl all RequestProcessor run cdl.countDown() ;
    long endTimestamp = System.currentTimeMillis();
    System.out.println("difference  = "+(endTimestamp - startTimestamp));