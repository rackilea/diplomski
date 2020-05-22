import java.util.*;

public class ReturnQueue 
{
public static void main(String[] args)
{
    Queue<Integer> myQueue = new LinkedList<Integer>();
    myQueue.add(12);
    myQueue.add(8);
    myQueue.add(9);
    myQueue.add(10);

    for (int i = 0; i < 4; i++)
    System.out.println(myQueue.poll());
}
}