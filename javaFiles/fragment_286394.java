private CountDownLatch inputLatch = new CountDownLatch(3);
 private Object[] input = new Object[3];

 public void setInput(int i, Object data) {
   input[i] = data;
   inputLatch.countDown(); // perhaps better check all input set
 }

 public Object processInput() {
   inputLatch.await();
   return process(input); // process in sequence
 }