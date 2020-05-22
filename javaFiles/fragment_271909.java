Algorithm : zeroCount(A)
Input : sorted array A containing 0s and 1s
Output : total number of 0s in A

if A[0]=1 then 
    return 0;
len <— A.length
if A[len-1]=0 then
    return len
 return  count(A,0,length)


Algorithm : count(A,lower,upper)
Input :  sorted array A , integers lower and upper 
Output : total number of 0s in A

mid <— (lower+upper) / 2

if A[mid] != A[mid-1] then 
    return mid

if A[mid] != A[mid+1] then
    return mid+1

if A[mid] = 1 then 
    return count(A,lower,mid-1)

if A[mid] = 0 then 
       return count(A,mid+1,upper)