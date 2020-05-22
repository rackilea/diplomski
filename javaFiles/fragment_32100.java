public class Counter {

    int count;

    public Counter() {
       count = 0;
    }


    public int getCount() {
       return count;
    }

    public /* need synchronized here */ void update(int value) {
       int buffer = 0;
       buffer = buffer + count;
       buffer = buffer + value;
       count = buffer;
    }

}

public class UpdateCounter extends Thread {

    public UpdateCounter(Counter counter, int amount) {
        this.counter = counter;
        this.name = name;
    }

    public void run() {
       System.out.printf("Adding %d to count\n", amount); 
       counter.update(amount);
       System.out.printf("Count is %d\n", counter.getCount());
    }
}

public static void main(String[] args) {
    Counter counter = new Counter();

    UpdateCounter x = new UpdateCounter(counter, 30);
    UpdateCounter y = new UpdateCounter(counter, 100);

    x.start();
    y.start();

}