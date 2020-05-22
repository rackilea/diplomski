public void method4() {
   lock2.lock();
   lock1.lock();
   // ...
   lock1.unlock();
   lock2.unlock();
}