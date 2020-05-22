while(keepGenerating) {
    synchronized (lock1) {
        Object temp = Thread.currentThread().getId();
        System.out.println("Thread is : " + temp);
        s1.add(random.nextInt(11));
    }
}