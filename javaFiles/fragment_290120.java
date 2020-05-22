import java.util.*;
import java.util.concurrent.*;

public class MergeSort<N extends Comparable<N>> extends RecursiveTask<List<N>> {
    private List<N> elements;

    public MergeSort(List<N> elements) {
        this.elements = new ArrayList<>(elements);
    }

    @Override
    protected List<N> compute() {
        if(this.elements.size() <= 1)
            return this.elements;
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
        List<N> sorted = new ArrayList<>();
        while(!left.isEmpty() || !right.isEmpty()) {
            if(left.isEmpty())
                sorted.add(right.remove(0));
            else if(right.isEmpty())
                sorted.add(left.remove(0));
            else {
                if( left.get(0).compareTo(right.get(0)) < 0 )
                    sorted.add(left.remove(0));
                else
                    sorted.add(right.remove(0));
            }
        }

        return sorted;
    }

    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        List<Integer> result = forkJoinPool.invoke(new MergeSort<Integer>(Arrays.asList(7,2,9,10,1)));
        System.out.println("result: " + result);
    }
}