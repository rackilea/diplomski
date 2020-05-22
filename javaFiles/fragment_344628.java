int i = 1;

Thread threadOne = new Thread() {
public void run() {
    i++;
    System.out.println("ThreadOne is " + i);
}
};

Thread threadTwo = new Thread() {
public void run() {
    i++;
    System.out.println("ThreadTwo is "+ i);
}
};

Thread threadThree = new Thread() {
public void run() {
    i++;
    System.out.println("ThreadThree is " + i);
}
};

threadOne.start();
threadTwo.start();
threadThree.start();