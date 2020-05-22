public void increment() {
    synchronized(Test1.class) {
        x=x+1;
        System.out.println(x+" "+ name);
    }
}