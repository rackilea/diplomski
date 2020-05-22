import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Stack;

public class PriorityStackProblem {

    private static final int NUMBER_OF_PASSES     = 100;
    private static final int MAX_START_STATE_SIZE = 100;
    private static final int MAX_OPERATIONS_SIZE  = 100;
    private static final int MAX_ITEM_VALUE       = 1000;

    public static abstract class MeasurableStack<T extends Comparable<? super T>> {

        protected int moves = 0;

        public abstract void load(final List<T> startState);
        public abstract void insert(final T value);
        public abstract T pop() throws NoSuchElementException;

        protected void move(
                final Stack<T> fromStack,
                final Stack<T> toStack) {
            toStack.push(fromStack.pop());
            moves++;
        }

        public void clearMoves() {
            moves = 0;
        }

        public int getMoves() {
            return moves;
        }

    }

    public static class TempHoldingStackApproach<T extends Comparable<? super T>>
    extends MeasurableStack<T> {

        private Stack<T> mainStack = new Stack<T>();
        private Stack<T> tempHoldingStack = new Stack<T>();

        @Override
        public void load(final List<T> startState) {
            mainStack.clear();
            tempHoldingStack.clear();
            clearMoves();
            T lastItem = null;
            for (final T item : startState) {
                mainStack.push(item);
                assert lastItem == null || item.compareTo(lastItem) >= 0;
                lastItem = item;
            }
        }

        @Override
        public void insert(final T value) {
            // slide higher priority items on main stack to temp stack
            while (!mainStack.isEmpty() && mainStack.peek().compareTo(value) > 0) {
                move(mainStack, tempHoldingStack);
            }

            assert mainStack.isEmpty() || mainStack.peek().compareTo(value) <= 0;
            assert tempHoldingStack.isEmpty() || tempHoldingStack.peek().compareTo(value) >= 0;

            mainStack.push(value);

            // slide them back
            while (!tempHoldingStack.isEmpty()) {
                move(tempHoldingStack, mainStack);
            }

            assert tempHoldingStack.isEmpty();
        }

        @Override
        public T pop() throws NoSuchElementException {
            assert tempHoldingStack.isEmpty();
            return mainStack.pop(); // will throw if empty
        }

    }

    public static class SplitStackApproach<T extends Comparable<? super T>>
    extends MeasurableStack<T> {

        private Stack<T> lowerStack = new Stack<T>();
        private Stack<T> higherStack = new Stack<T>();

        @Override
        public void load(final List<T> startState) {
            lowerStack.clear();
            higherStack.clear();
            clearMoves();
            T lastItem = null;
            for (final T item : startState) {
                lowerStack.push(item);
                assert lastItem == null || item.compareTo(lastItem) >= 0;
                lastItem = item;
            }
        }

        @Override
        public void insert(final T value) {
            // only one of the while loops below should really execute

            // slide any higher priority items on lower stack to higher stack
            while (!lowerStack.isEmpty() && lowerStack.peek().compareTo(value) > 0) {
                move(lowerStack, higherStack);
            }

            // slide any lower priority items on higher stack to lower stack
            while (!higherStack.isEmpty() && higherStack.peek().compareTo(value) < 0) {
                move(higherStack, lowerStack);
            }

            assert lowerStack.isEmpty() || lowerStack.peek().compareTo(value) <= 0;
            assert higherStack.isEmpty() || higherStack.peek().compareTo(value) >= 0;

            lowerStack.push(value);
        }

        @Override
        public T pop() throws NoSuchElementException {
            // get to highest priority item
            while (!higherStack.isEmpty()) {
                move(higherStack, lowerStack);
            }

            assert higherStack.isEmpty();
            return lowerStack.pop(); // will throw if empty
        }

    }

    public static class OddEvenStackApproach<T extends Comparable<? super T>>
    extends MeasurableStack<T> {

        private Stack<T> oddStack = new Stack<T>();
        private Stack<T> evenStack = new Stack<T>();

        @Override
        public void load(final List<T> startState) {
            oddStack.clear();
            evenStack.clear();
            clearMoves();
            for (final T item : startState) {
                if (item.hashCode() % 2 == 1) {
                    oddStack.push(item);
                } else {
                    evenStack.push(item);
                }
            }
        }

        @Override
        public void insert(final T value) {
            if (value.hashCode() % 2 == 1) {
                insert(value, oddStack, evenStack);
            } else {
                insert(value, evenStack, oddStack);
            }
        }

        @Override
        public T pop() throws NoSuchElementException {
            if (oddStack.size() <= 0) {
                return evenStack.pop();  // will throw if empty
            } else if (evenStack.size() <= 0) {
                return oddStack.pop();  // will throw if empty
            } else {
                final T oddTop = oddStack.peek();
                final T evenTop = evenStack.peek();
                if (oddTop.compareTo(evenTop) >= 0) {
                    return oddStack.pop();  // will throw if empty
                } else {
                    return evenStack.pop();  // will throw if empty
                }
            }
        }

        private void insert(
                final T value,
                final Stack<T> targetStack,
                final Stack<T> tempHoldingStack) {
            final int oldTargetStackSize = targetStack.size();
            final int oldHoldingStackSize = tempHoldingStack.size();

            int movedItems = 0;

            // slide any higher priority items on target stack to holding stack
            while (!targetStack.isEmpty() && targetStack.peek().compareTo(value) > 0) {
                move(targetStack, tempHoldingStack);
                movedItems++;
            }

            assert targetStack.isEmpty() || targetStack.peek().compareTo(value) <= 0;
            assert movedItems == 0 || tempHoldingStack.peek().compareTo(value) >= 0;

            targetStack.push(value);

            // slide items back
            while (movedItems > 0) {
                move(tempHoldingStack, targetStack);
                movedItems--;
            }

            assert targetStack.size() == oldTargetStackSize + 1;
            assert tempHoldingStack.size() == oldHoldingStackSize;
        }

    }

    private static List<Integer> generateStartState(final Random random) {
        final int size = random.nextInt(MAX_START_STATE_SIZE-1);
        final List<Integer> startState = new ArrayList<Integer>(size);
        for (int i = 0; i < size; i++) {
            startState.add(random.nextInt(MAX_ITEM_VALUE-1));
        }
        Collections.sort(startState);
        return startState;
    }

    private static List<Integer> generateOperations(
            final Random random,
            final int startStateSize) {
        final int size = random.nextInt(MAX_OPERATIONS_SIZE-1);
        final List<Integer> operations = new ArrayList<Integer>(size);
        int count = startStateSize;
        for (int i = 0; i < size; i++) {
            if (count > 0 && random.nextInt(2) == 0) {
                // null means pop
                operations.add(null);
                count--;
            } else {
                // non-null means insert the item
                operations.add(random.nextInt(MAX_ITEM_VALUE-1));
                count++;
            }
        }
        return operations;
    }

    private static <T extends Comparable<? super T>> int execute(
            final List<T> startState,
            final List<T> operations,
            final MeasurableStack<T> stack) {
        System.out.print(stack.getClass().getSimpleName()+" Moves:\t");
        stack.load(startState);
        for (final T item : operations) {
            if (item == null) {
                stack.pop();
            } else {
                stack.insert(item);
            }
            System.out.print(item+" ("+stack.getMoves()+") ");
        }
        System.out.println();
        return stack.getMoves();
    }

    private static float average(final int[] results) {
        int total = 0;
        for (final int moves : results) {
            total += moves;
        }
        return total / (float) results.length;
    }

    public static void main(final String[] args) {
        final Random random = new Random();

        final int[] holdingStackResults = new int[NUMBER_OF_PASSES];
        final int[] splitStackResults   = new int[NUMBER_OF_PASSES];
        final int[] oddEvenStackResults = new int[NUMBER_OF_PASSES];

        for (int pass = 0; pass < NUMBER_OF_PASSES; pass++) {

            final List<Integer> startState = generateStartState(random);
            final List<Integer> operations = generateOperations(random, startState.size());

            System.out.println("Start State ["+startState.size()+"]:\t"+startState);
            System.out.println("Operations ["+operations.size()+"]:\t"+operations);
            System.out.println();

            System.out.println("Moves: item (moves) item (moves) ...\t");

            holdingStackResults[pass] =
                execute(startState, operations, new TempHoldingStackApproach());

            splitStackResults[pass] =
                execute(startState, operations, new SplitStackApproach());

            oddEvenStackResults[pass] =
                execute(startState, operations, new OddEvenStackApproach());

            System.out.println();
            System.out.println(
                    "Holding: \t" + holdingStackResults[pass] + " total moves\n" +
                    "Split:   \t" + splitStackResults[pass]   + " total moves\n" +
                    "Odd/Even:\t" + oddEvenStackResults[pass] + " total moves");
            System.out.println("---");

        }

        System.out.println("Holding Stack Results:\t"+Arrays.toString(holdingStackResults));
        System.out.println("Split Stack Results:\t"+Arrays.toString(splitStackResults));
        System.out.println("Odd/Even Stack Results:\t"+Arrays.toString(oddEvenStackResults));
        System.out.println();

        final float holdingStackAverage = average(holdingStackResults);
        final float splitStackAverage   = average(splitStackResults);
        final float oddEvenStackAverage = average(oddEvenStackResults);

        System.out.println("Holding Stack Avg Moves\t\t= "  + holdingStackAverage+" moves");
        System.out.println("Split Stack Avg Moves\t\t= "  + splitStackAverage+" moves");
        System.out.println("Odd/Even Stack Avg Moves\t= " + oddEvenStackAverage+" moves");
        System.out.println();
    }
}