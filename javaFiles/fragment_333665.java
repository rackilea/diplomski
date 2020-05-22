public static void main(String[] args) 
{
    int[] a = {1,25,2,6,4,3,23,30,32,14,11,8};
    Arrays.sort(a);
    int target = a[7];
//here you want the index of the first location to search, not the value in that index
//so you use 0 instead of a[0]
    int first = 0;
//the last element index is length-1, not length, since arrays are 0-based
    int last = a.length - 1;     
    for(int i=0;i<a.length;i++)
    {
        System.out.print(" "+a[i]);
    }
    System.out.println("\n"+binarySearch(target,first,last,a));
}

public static int binarySearch(int target,int first, int last, int[] a)
{
    int result;
    if(first>last)
        return -1;
    else
    {
        int mid = (first+last)/2;
//here you need to check if the target is equal to the value at the index mid
//before you were checking if the target was equal to the index, which was never true
        if(target == a[mid])
//you want to return the value at the target, not the index of the target
//so use a[mid] not mid
            result = a[mid];
        else if(target<a[mid])
//here you want to search from first to mid-1
//before you were searching from first to last-1, which is not correct binary search
            result = binarySearch(target,first,mid - 1,a);
        else
            result = binarySearch(target,mid + 1,last,a);

    }
    return result;
}