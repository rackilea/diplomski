class Foo {
    public static ThreadLocal<Long> localSum = new ThreadLocal<Long>() {
        public Long initialValue() {
            return new Long(0);         
        }
    };
}

class Task implements Callable<Long> {

    private int start = 0;
    private int end = 0;    

    public Task(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public Long call() {
        for(int i = start; i < end; i++) {
            Foo.localSum.set(Foo.localSum.get() + i);
        }
        return Foo.localSum.get();
    }
}