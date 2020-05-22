private void updateList(int i) {
    synchronized (myList) {
        myList.add(i);
        System.out.println(Thread.currentThread().getName() + " added " + i);
    }
}