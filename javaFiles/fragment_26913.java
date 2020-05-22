import java.util.NoSuchElementException;

public class CircularArrayQueue implements MyQueue 
{
private Integer[] array;
//initial size of the array
private int N;
private int front;
private int rear;
private int count = 0;//total number of items currently in queue.
public CircularArrayQueue()
{
    this.N = 10;
    array = new Integer[N];
    front = rear = 0;
}

public CircularArrayQueue(int size)
{
    this.N = size;
    array = new Integer[N];
    front = rear = 0;
}


//enqueues an element at the rear of the queue
// if the queue is already full it is resized, doubling its size
@Override
public void enqueue(int in) 
{
    count++;
    if (isFull())
    {
       resize();
       rear = (rear + 1) % N;
       array[rear] = in;
    }
    else
    {
       rear = (rear + 1) % N;
       array[rear] = in;
    }            
}

public void resize()
{
    Integer[] temp = new Integer[array.length*2];
    N = array.length*2;
    for(int i=0; i<array.length; i++)
    {
        temp[i] = array[i];
    }

    array = temp;
}


//dequeues an element
// if the queue is empty a NoSuchElement Exception is thrown
@Override
public int dequeue() throws NoSuchElementException 
{
    if(isEmpty())
    {
        throw new Exception("The queue is empty");
    }

    front = (front + 1) % N;
    int headElement = array[front];   
    count--;
    return headElement;
}

@Override
public int noItems() 
{   
    return count;
}

@Override
public boolean isEmpty()
{
    return front == rear;
}

@Override
public boolean isFull()
{
    return front == ((rear + 1) % N);
}

//return the number of indexes that are empty
public int getCapacityLeft()
{
    return N - 1 - count;
}   
}