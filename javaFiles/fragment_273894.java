import java.util.Stack;

public class StatisticanStack {

    Stack<Double> stack = new Stack<Double>();

    public void nextNumber(Double stackNums) {
        stack.push(stackNums);
    }

    public void nextNumber(Integer stackNums) {
        stack.push(new Double(stackNums));
    }

    public int length() {
        return stack.size();
    }

    public double sum() {
        return stack.stream()
        .mapToDouble(Double::doubleValue)
        .sum();
    }

    public double mean() {
        return stack.stream()
                .mapToDouble(Double::doubleValue)
                .average().getAsDouble();
    }

    public double largestNum() {
        return stack.stream()
                .mapToDouble(Double::doubleValue)
                .max().getAsDouble();
    }

    public double smallestNum() {
        return stack.stream()
                .mapToDouble(Double::doubleValue)
                .min().getAsDouble();
    }

    public static void main(String... args) {
        StatisticanStack stack = new StatisticanStack();
        stack.nextNumber(-1);
        stack.nextNumber(2.34);
        stack.nextNumber(17);
        System.out.println(stack.smallestNum());
        System.out.println(stack.largestNum());
        System.out.println(stack.mean());
        System.out.println(stack.sum());
    }

}