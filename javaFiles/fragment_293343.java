public void main(...) {
    MyTask tj1 = new Thread(new MyTask());
    MyTask tj2 = new Thread(new MyTask());
    MyTask tj3 = new Thread(new MyTask());
    MyTask tj4 = new Thread(new MyTask());

    tj1.start();
    tj2.start();
    tj3.start();
    tj4.start();

    ...

    t3.grantPermissionToDie();
    t3.join();

    t2.grantPermissionToDie();
    t2.join();

    t1.grantPermissionToDie();
    t1.join();

    t4.grantPermissionToDie();
    t4.join();
}