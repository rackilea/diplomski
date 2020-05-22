class CircularArrayQueue {
    private final int CAPACITY = 10;
    private int[] data;         
    private int front = 0;   
    private int rear = 0;
    private int size = 0;       


    public CircularArrayQueue() {
        data = new int[CAPACITY];
    }

    public CircularArrayQueue(int capacity) {
        data = new int[capacity];
    }

    public void enqueue(int element) {
        if (size == data.length) {
            resize();
        }
        data[rear] = element;
        rear = (rear + 1) % data.length;
        size++;
    }

    public void resize() {
        int[] temp = data;
        int currentLength = data.length;
        data = new int[2*currentLength];

        for (int i = 0; i < currentLength; i++) {
            data[i] = temp[(i + front) % currentLength];
        }

        front = 0;
        rear = currentLength;
    }

    public int dequeue() {
        if (size == 0) 
            return Integer.MIN_VALUE;

        int temp = data[front];
        data[front] = 0;
        front = (front + 1) % data.length;
        size--;
        return temp;
    }

    public int peek() {
        if (size == 0) 
            return Integer.MIN_VALUE;

        return data[front];
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size==0;
    }

    public void printQueue() {
        if(size == 0) {
            System.out.println("Queue is EMPTY!");
        }else {
            System.out.print("Queue: ");
            for(int i = 0; i < size; i++) {
                System.out.print(data[(i+front)%data.length]+" ");
            }
            System.out.println("");
        }
    }

    public void printArray() {
        System.out.print("Array: ");
        for(int i : data) {
            System.out.print(i+" ");
        }
        System.out.println("");
    }
}