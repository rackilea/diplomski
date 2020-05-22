//Initialisation of the variable. Here an initial value of zero is assigned.
ThreadLocal<Integer> x = ThreadLocal.withInitial(()-> 0);

//Incrementing the value by one:
x.set(x.get() + 1);

//Outputting the result:
System.out.println("x=" + x.get() + " | thread id=" 
                            + Thread.currentThread().getId() + "| 100*x+x=" + (100 * x.get() + x.get()));