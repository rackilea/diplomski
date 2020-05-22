public void add(Object someObject){
    synchronized (lock1) {
        if(a.size()>limit) {
            System.out.println("Array is full");
        } else {
           a.add(someObject)
        }
    }
}