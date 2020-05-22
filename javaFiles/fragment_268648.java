final Queue12<T> ringBuffer = new QueueImpl12<T>();
T o = (T) new String("this");
ringBuffer.enqueue(o); //add element to the back
System.out.println(ringBuffer.peek());//this should print 'this' in the console\
//assertEquals('this', ringBuffer.peek());
ringBuffer.dequeue();  //remove/return element in the front