public void run() {
    for (int i = 0; i < 10000; i++) {
        if (interrupted()) break;
        System.out.println(i + "thread1");
    }
}