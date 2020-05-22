while(lo<=hi)
{
    if(a[mid]>key)
        hi = mid-1;
    else if(a[mid]<key)
        lo = mid+1;
    else 
        return mid;

    mid = (lo+hi)/2;
}