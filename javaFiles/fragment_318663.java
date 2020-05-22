private void myMethod() {
    synchronized (myArrayList) {
        for (MyObject o: myArrayList) {
            System.out.println(o);
        }
        myArrayList.clear();
    }
}