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
        int leftIndex = 0;
        int rightIndex = 0;
        while(leftIndex < left.size() || rightIndex < right.size()) {
            if(leftIndex >= left.size())
                left.add(leftIndex++, right.get(rightIndex++));
            else if(rightIndex >= right.size())
                return left;
            else {
                if( left.get(leftIndex).compareTo(right.get(rightIndex)) < 0 )
                    leftIndex++;
                else
                    left.add(leftIndex++, right.get(rightIndex++));
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