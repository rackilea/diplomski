//fields
private T item;
private int size;
private CBTree<T> left, right;

//add method
public void add(T item) 
{
    if(left == null)
    {
        left = new CBTree<T>(item);
    }
    else if(right == null)
    {
        right = new CBTree<T>(item);
    }
    else if(leftFull())
    {
        right.add(item);
    }
    else
    {
        left.add(item);
    }
    size++;
}

//Checks if the left subtree is full
public boolean leftFull()
{
    int used, leafs = 1;
    while(leafs <= size + 1)
    {
        leafs *= 2;
    }

    leafs /= 2;
    used = (size + 1) % leafs;
    if(used >= (leafs / 2))
    {
        return true;
    }
    else
    {
        return false;
    }
}