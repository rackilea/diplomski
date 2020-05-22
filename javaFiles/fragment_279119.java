public class SomeTask {

    private final ReadWriteLock[] locks = locks(5);
    private int[] table;
    private int upperRange;

    public SomeTask(int[] table, int upperRange) {
        this.table = table;
        this.upperRange = upperRange;
    }

    public void makeSelectionOfGivenNumber(int number) {
        if (this.table[number] != 0) {
            int multiple;
            multiple = number + number;
            while (multiple <= upperRange) {
                ReadWriteLock lock = getLock(multiple);
                try {
                    lock.writeLock().lock();
                    this.table[multiple] = 0;
                } finally {
                    lock.writeLock().unlock();
                }
                multiple += number;
            }
        }
    }

    private ReadWriteLock getLock(int number) {
        return locks[(locks.length - 1) & number];
    }

    private ReadWriteLock[] locks(int size) {
        ReadWriteLock[] result = new ReadWriteLock[size];
        for (int i = 0; i < size; i++) {
            result[i] = new ReentrantReadWriteLock();
        }
        return result;
    }