long stime = System.nanoTime(); //Start Time
  list.add(new Item(id, "A")); // at this point two things are happening
  // creation of instance & addition into ArrayList
  // both takes their own time.

  long elapsedTime = System.nanoTime() - stime; //Elapsed time