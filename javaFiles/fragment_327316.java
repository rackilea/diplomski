synchronized (lock) {
    while (flagObj.flag == false) {
        lock.wait();
    }

    System.out.println(i);

    flagObj.flag = false;
    lock.notify();
}