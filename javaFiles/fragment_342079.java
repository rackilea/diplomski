if(A[mid]==key)
       return true;
 if(A[mid]<key)
       return Bsearch( A, mid+1, high, key);
 if(A[mid]>key)
       return Bsearch(A, low, mid-1, key);