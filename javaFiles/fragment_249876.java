public int count() // total person count including this object
{
    int count = 1; // we count this node as 1 
    if (child1 != null) // if we have a left child, count its size
        count += child1.count();
    if (child2 != null) // if we have a right child, count its size
        count += child2.count()
    return count;
}