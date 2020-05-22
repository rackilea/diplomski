boolean sorted(int[] a , int s , int n)
{
    if(s+1==n)
        return true ;
    if(a[s]<=a[s+1])
        return sorted(a,s+1,n); // Here!      
    return false ;
}