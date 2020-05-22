static locks[] = new Lock[ ... ];
static { /* initialize lock array */ } 
int id;
void doSomething() {
  final lock = locks[id % locks.length];
  lock.lock();
  try {
    /* protected code */
  } finally {
    lock.unlock();
  } 
}