static boolean isMaxHeap(int[] H, int idx)
{
    // Check for going off the end of the array
    if (idx >= H.length)
    {
        return true;
    }

    // Check the left child.
    int leftChild = 2*idx;
    if (leftChild < H.length)
    {
        if (H[leftChild] > H[idx])
           return false;
        if (!isMaxHeap(H, leftChild)
            return false;
    }

    // Check the right child.
    int rightChild = 2*idx + 1;
    if (rightChild < H.length)
    {
        if (H[rightChild] > H[idx])
            return false;
        return isMaxHeap(H, rightChild);
    }

    return true;
}