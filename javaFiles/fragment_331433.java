/**
 * Assumes both array are sorted in ascending order
 * Array a has length n and contains n elements
 * Array b has length m+n and contains m elements
 * The merged, sorted array will be returned in b
 */

public void merge(int [] a, int [] b)
{
    //b is the one with m+n space
    int indexA = a.length - 1; //points to last element in a
    int indexB = b.length - a.length - 1; //points to last element in b
    int writeTo = b.length - 1; //points to last free position

    while(indexA > -1 && indexB > -1)
    {
        if(a[indexA] > b[indexB])
        {
            b[writeTo--] = a[indexA--]
        }
        else
        {
            b[writeTo--] = b[indexB--];
        }
    }

    //are there any elements left-over in a?
    //any elements left-over in b will already be in their right place
    while(indexA > -1)
    {
        b[writeTo--] = a[indexA--];
    }
}