public class MyStack
{

    Object[] elements;
    int size;
    int capacity;

    public MyStack()
    {
        this.capacity = 1;
        this.elements = new Object[capacity];
        this.size = 0;

    }

    public boolean isEmpty()
    {
        return (size == 0);
    }

    public void push(Object obj)
    {
        if (size == capacity) {
            capacity = capacity * 2;
            resize();
        }
        elements[size] = obj;
        size++;
    }

    public Object pop() throws Exception
    {
        if (isEmpty()) {
            throw new Exception();
        }

        this.size--;
        Object result = this.elements[size];
        this.elements[size] = null;

        if (size < (capacity / 4)) {
            capacity = capacity / 2;
            resize();
        }
        return result;
    }

    private void resize()
    {
        Object temp[] = elements;
        elements = new Object[capacity];

        for (int i = 0; i < size; i++) {
            elements[i] = temp[i];
        }
    }

    public static void main(String[] args) throws Exception
    {
        MyStack my = new MyStack();
        my.push(1);
        my.push(2);
        my.push(3);
        my.push(4);
        my.push(5);

        Object o5 = my.pop();
        Object o4 = my.pop();
        Object o3 = my.pop();
        Object o2 = my.pop();
        Object o1 = my.pop();
        Object o0 = null;
        try {
            o0 = my.pop();
        } catch (Exception e) {
            System.out.println("Empty stack");
        }
        System.out.println(String.format("%s %s %s %s %s %s", o5, o4, o3, o2, o1, o0));

    }
}