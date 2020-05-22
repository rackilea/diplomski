class MyClass1 implements Runnable { /* code here */ }
class MyClass2 implements Runnable { /* code here */ }

Runnable[] runnables = { new MyClass1(), new MyClass2() };

for (Runnable runnable : runnables)
  runnable.run();