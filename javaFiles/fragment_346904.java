FibonacciThread p1 = new FibonacciThread(x-1);
FibonacciThread p2 = new FibonacciThread(x-2);
p1.start();
p2.start();

p1.join();
p2.join();
int result = p1.result + p2.result;