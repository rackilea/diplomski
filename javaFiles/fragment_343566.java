public class QueueNode {

    private int front=-1;
    private int rear=-1;
    private int capacity;
    private Node[] arr;

    public QueueNode(int capacity)
    {
        this.capacity=capacity;
        arr=new Node[capacity];
    }

    private boolean isEmpty()
    {
        return front==-1;
    }

    private boolean isFull()
    {
        return (rear+1)%capacity==front;
    }

    public void push(Node data) throws Exception
    {
        if(isFull())
            throw new Exception("Queue is Full");
        else
        {
            rear=(rear+1)%capacity;
            arr[rear]=data;
            if(front==-1)
                front=rear;
        }

    }

    public Node pull() throws Exception
    {
        Node data=null;
        if(isEmpty())
        {
            throw new Exception("Queue is Empty");
        }else
        {
            data=arr[front];
            if(front==rear)
                front=rear-1;
            else
            {
                front=(front+1)%capacity;
            }
        }

        return data;
    }
}