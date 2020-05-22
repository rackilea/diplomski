Object[] arr = new Object[10];
int index = 0;

public void add(Object obj)
{
    if (index < arr.length)
        arr[index++] = obj; // add an object to the first empty spot, if the array is not full
}