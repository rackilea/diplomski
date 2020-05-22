import java.util.Collections;
import java.util.PriorityQueue;

public class DOS
{

    double a;
    PriorityQueue<Integer> heap;
    PriorityQueue<Integer> heap_large_elements;

    public DOS(double a) {
        this.a = a;
        this.heap = new PriorityQueue<>(10, Collections.reverseOrder());
        this.heap_large_elements = new PriorityQueue<>();
    }

    public void add(int x){
        if(heap.size() == 0 || x < heap.peek())
            heap.add(x); // O(log n/a)
        else
            heap_large_elements.add(x); // O(log n)

        //possible rebalance operations
        int n = heap.size() + heap_large_elements.size();
        if(heap.size() > Math.ceil(n/a)){
            heap_large_elements.add(heap.poll()); //O(log n)
        }else if(heap.size() < Math.ceil(n/a)) {
            heap.add(heap_large_elements.poll()); //O(log n)
        }
    }

    public int get(){
        return heap.peek(); //O(1)
    }

    public static void main(String[] args)
    {
        DOS d = new DOS(3);
        d.add(5);d.add(6);d.add(2);d.add(3);d.add(8);d.add(12);d.add(9);
        System.out.println(d.get());
    }

}