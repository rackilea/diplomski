boolean isHeap(int[] arr, int i, int n)// array storing the tree, initial postion , size
{
   if (i > (n - 2)/2) //Root
       return true;

   // If an internal node and is greater than its children, and
   // same is recursively true for the children
   if (arr[i] >= arr[2*i + 1]  &&  arr[i] >= arr[2*i + 2] &&
       isHeap(arr, 2*i + 1, n) && isHeap(arr, 2*i + 2, n))
       return true;

   return false;
}