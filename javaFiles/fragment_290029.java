public static void main(String[] args)
{
    ImmutableQueue<Integer> newQueue = new ImmutableQueue<Integer>();
    newQueue.enqueue(5);
    newQueue.enqueue(10);
    newQueue.enqueue(15);
    int x = newQueue.size();
    //ImmutableQueue<Integer> x = newQueue.dequeue();
    System.out.println(x);

}