import java.util.stream.IntStream;

public class Multiplier {

    private final int digits;

    public Multiplier(int digits) {
        this.digits = digits;
    }

    /**
     * @param multiplificationSteps
     * @return a stream, containing all numbers of the given digits, each multiplied several times with each other
     * 
     * digits=1 with multiplificationSteps=1 => output [1;9] 
     * digits=2 with multiplificationSteps=1 => output [10;99] 
     * digits=1 with multiplificationSteps=2 => output [1;9] & [2;19] & ... & [9;81] 
     */
    public IntStream createFullStream(int multiplificationSteps) {
        IntStream intStream = makeIntStream();
        for (int i = 1; i < multiplificationSteps; i++)
            intStream = intStream.flatMap(this::multiplyStream);
        return intStream;
    }

    /**
     * @param input a multiplier
     * @return the stream, having each number multiplied by the multiplier
     * 
     * input [1;9]   and 1 => output [1;9]
     * input [1;9]   and 2 => output [2;18]
     * input [10;99] and 3 => output [30;297]
     */
    private IntStream multiplyStream(int input) {
        return makeIntStream().map(k -> input * k);
    }

    /**
     * @return a stream of all numbers with the given number of digits
     * 
     * input 1 => output [1;9]
     * input 2 => output [10;99]
     * input 3 => output [100;999]
     */
    private IntStream makeIntStream() {
        int startNumber = (int) Math.pow(10, digits - 1);
        int endNumber   = (int) Math.pow(10, digits);
        return IntStream.range(startNumber, endNumber);
    }

    public static void main(String[] args) {
        new Multiplier(1).createFullStream(2).forEach(System.out::println);
    }
}