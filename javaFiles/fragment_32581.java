public class Main {
    public static void main(final String[] args) {
        final StackX stackX = new StackX(5);
        stackX.push(20);
        stackX.push(40);
        stackX.push(60);
        stackX.push(80);

        removeDownTo(stackX, 60);

        // Prints remaining elements
        while (!stackX.isEmpty()) {
            System.out.println(stackX.pop());
        }

        System.out.println(stackX.isEmpty());
    }

    private static void removeDownTo(
            final StackX stack,
            final long downTo) {
        while (!stack.isEmpty()) {
            if (stack.peek() == downTo) {
                return;
            }

            stack.pop();
        }
    }
}