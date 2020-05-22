value = counter.incCounter();
System.out.println(getName()+": "+value);

synchronized (counter) {
    value = counter.incCounter();
    System.out.println(getName()+": "+value);
}