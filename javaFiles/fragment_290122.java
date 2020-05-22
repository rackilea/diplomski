import java.util.*;
import java.util.concurrent.*;

public class MergeSort<N extends Comparable<N>> extends RecursiveTask<List<N>> {
    private List<N> elements;

    public MergeSort(List<N> elements) {
        this.elements = elements;
    }

    @Override
    protected List<N> compute() {
        if(this.elements.size() <= 1)
            return new LinkedList<>(this.elements);
        else {
            final int pivot = this.elements.size() / 2;
            MergeSort<N> leftTask = new MergeSort<N>(this.elements.subList(0, pivot));
            MergeSort<N> rightTask = new MergeSort<N>(this.elements.subList(pivot, this.elements.size()));

            leftTask.fork();
            rightTask.fork();

            List<N> left = leftTask.join();
            List<N> right = rightTask.join();

            return merge(left, right);
        }
    }

    private List<N> merge(List<N> left, List<N> right) {
        ListIterator<N> leftIter = left.listIterator();
        ListIterator<N> rightIter = right.listIterator();
        while(leftIter.hasNext() || rightIter.hasNext()) {
            if(!leftIter.hasNext()) {
                leftIter.add(rightIter.next());
                rightIter.remove();
            }
            else if(!rightIter.hasNext())
                return left;
            else {
                N rightElement = rightIter.next();
                if( leftIter.next().compareTo(rightElement) < 0 )
                    rightIter.previous();
                else {
                    leftIter.previous();
                    leftIter.add(rightElement);
                }
            }
        }

        return left;
    }

    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        List<Integer> result = forkJoinPool.invoke(new MergeSort<Integer>(Arrays.asList(7,2,9,-7,777777,10,1)));
        System.out.println("result: " + result);
    }
}