private static void mergeSort(int[] a, int low , int high,int[] res)
{
    int mid = (low + high)  /2;
    if (low + 1 < high)
    {
        //  Sort sub-parts
        mergeSort(a,low,mid,res);
        mergeSort(a,mid,high,res);

        //  Merge back to "res"
        merge(a,low,mid,high,res);
    }else{
        res[low] = a[low];
    }
}

private static void merge(int[] a, int low , int mid , int high,int[] res)
{

    int i = low;
    int j = mid;

    int k = low;   //  Use "low" instead of 0.

    while (i < mid && j < high)
        if(a[i] < a[j])
               res[k++] = a[i++];
        else
              res[k++] = a[j++];


    while(i < mid)
        res[k++] = a[i++];

    while(j < high)
        res[k++] =a[j++];

    //  Copy back to "a"
        for (int c = low; c < high; c++){
            a[c] = res[c];
        }

}