public int fibonacci(int n) {
  if (n == 0 || n == 1) {
     System.out.println("your value is: " +n+ " and its Fibonacci value is: "+n);
     return n;
  } else {
    System.out.println("your value is: " +n+ " and its Fibonacci value is: "+fibonacci(n - 1) + fibonacci(n - 2));
    return fibonacci(n - 1) + fibonacci(n - 2);
  }
}