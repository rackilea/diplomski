public static void method() {
  try {
    // stuff which doesn't declare checked exceptions
  } catch (Throwable t) { 
    throw t; 
  }
}