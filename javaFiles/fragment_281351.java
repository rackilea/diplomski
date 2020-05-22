ConcurrentHashMap<Integer, Integer> chm = new ConcurrentHashMap<Integer, Integer>();
Integer value = chm.get(key);

if(value != null) {
    value.doSomething(); // P.S. Integer class doesn't have a doSomething() method
                         // but I guess this is just an example of calling some arbitrary 
                         // instance method
    chm.remove(key);
}