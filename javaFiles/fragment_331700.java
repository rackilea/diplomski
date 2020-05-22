private static int binarySearch(int A[],int y, int index)
    {   
        y=-y;
        int max = A.length-1;
        int min = index + 1;
        int mid;
        int start = A.length;
        int end = 0;
        while (max>=min)
        {      
            mid = (max+min)/2;
            if (y==A[mid])
            {
                start = Math.min(start, mid);
                max = mid - 1;
            } else  
            if (y<A[mid]) 
            {
                max=mid-1;
            }
            else
            {
                min=mid+1;
            }
        }
        int max = A.length - 1;
        int min = index + 1;
        while (max>=min)
        {      
            mid = (max+min)/2;
            if (y==A[mid])
            {
                end = Math.max(end, mid);
                min= mid + 1;
            } else if (y<A[mid]) 
            {
                max=mid-1;
            }
            else
            {
                min=mid+1;
            }
        }
        if(start <= end) 
           return end - start + 1;
        return 0;
}