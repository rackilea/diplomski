import java.util.*;
import java.lang.*;
import java.io.*;

class Main{
    public static void main (String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(5);
        queue.add(4);
        queue.add(3);
        queue.add(2);
        queue.add(1);
        List<Integer> list = new ArrayList<>();
        while(!queue.isEmpty()) {
            list.add(0,queue.poll());
        }
        System.out.println(list);  // Prints [5, 4, 3, 2, 1]

    }
}