public aspect Audit {  // An aspect then compiles as if it was a class (at runtime, it is a normal class)

  Object around() :  // This is an around advice
    execution(@Auditable * *(..)) // Here you're catching execution of any method of any class with any parameter and any return type, which is annotated with @Auditable
  {
    // Do what you want to do before the method
    long start = System.nanoTime();
    Logger.log("I'm entering into " + thisJoinPoint); // with thisJoinPoint you can extract a lot of informations, like what class, what method, what parameters, on which instance etc..
    try {
      Object ret = proceed(); // "proceed" goes on executing the method
      // You could log, or do whatever you want with the return value, which could be "Void".
      return ret;
    } finally {
      Logger.log("It took ns: " + (System.nanoTime() - start));
    }
  }

}