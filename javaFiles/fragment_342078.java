if(A[mid]==key)
  return true;
else if(A[mid]<key)
  return Bsearch( A, mid+1, A.length, key)
else 
  //this is an implict A[mid]>key
  return Bsearch(A, 0, mid-1, key)

 //return false; //no longer required.