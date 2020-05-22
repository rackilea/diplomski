class MyThreadRunnable implements Runnable {
    List<String> strings;

    MyThreadRunnable(List<String> strings) {
        this.strings = strings;
    }

    public void run() {
        strings.add(getName());
    }
}

// ...

List<String> sharedStrings = new ArrayList<String>();
Thread t1 = new Thread(new MyThreadRunnable(sharedStrings));
Thread t2 = new Thread(new MyThreadRunnable(sharedStrings));

t1.start();
t2.start();