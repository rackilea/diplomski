public void bar(){  
    Integer value;
    synchronized (iterator) {
        value = iterator.next();  
    }
    doSomethingWithAnInteger(value);
}