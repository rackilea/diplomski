import java.util.concurrent.ThreadLocalRandom;

public class Generator {

    int size;
    String type;
    long[] generatedArray;

    public Generator(int mysize, String mytype) {
        size = mysize;
        type = mytype;
        generatedArray = new long[size];
    }

    public void ascending() {
        for (int i = 0; i < this.size; i++)
            generatedArray[i] = i + 1;
    }

    public void descending() {
        for (int i = this.size - 1; i >= 0; i--)
            generatedArray[i] = i + 1;
    }

    public void random() {
        for (int i = 0; i <= this.size - 1; i++)
            generatedArray[i] = ThreadLocalRandom.current().nextInt(-10 * this.size, 10 * this.size);
    }

    public void randominter() {
        for (int i = 0; i <= this.size - 1; i++)
            if (i % 2 == 0)
                generatedArray[i] = ThreadLocalRandom.current().nextInt(1, 10 * this.size);
            else if (i % 2 == 1)
                generatedArray[i] = ThreadLocalRandom.current().nextInt(-10 * this.size, -1);
    }

    public long[] getArray() {
        if (type.equalsIgnoreCase("descending")) {
            this.descending();
            return generatedArray;
        }
        if (type.equalsIgnoreCase("ascending")) {
            this.ascending();
            return generatedArray;
        }
        if (type.equalsIgnoreCase("random")) {
            this.random();
            return generatedArray;
        }
        if (type.equalsIgnoreCase("randominter")) {
            this.randominter();
            return generatedArray;
        }
        return null;
    }
}