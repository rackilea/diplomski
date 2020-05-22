import java.util.Stack;

public class StackSort {

    public final static void main(String[] args) {
        Stack<Stack<Integer>> stacks = new Stack<>();
        Stack<Integer> stackI1 = new Stack<>();
        stackI1.push(Integer.valueOf(1));
        stackI1.push(Integer.valueOf(2));
        stackI1.push(Integer.valueOf(3));
        Stack<Integer> stackI2 = new Stack<>();
        stackI2.push(Integer.valueOf(7));
        stackI2.push(Integer.valueOf(8));
        stackI2.push(Integer.valueOf(9));
        Stack<Integer> stackI3 = new Stack<>();
        stackI3.push(Integer.valueOf(4));
        stackI3.push(Integer.valueOf(5));
        stackI3.push(Integer.valueOf(6));

        stacks.push(stackI1);
        stacks.push(stackI2);
        stacks.push(stackI3);

        System.out.println(stacks);

        stacks.sort((stack1, stack2) -> {
            if (stack1.isEmpty()) {
                return stack2.isEmpty() ? -1 : 0;
            }
            if (stack2.isEmpty()) {
                return 1;
            }

            return stack1.get(0).compareTo(stack2.get(0));
        });

        System.out.println(stacks);
    }
}