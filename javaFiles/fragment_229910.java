function (array X) 
       low  = 0
       high = (num of elements in X) - 1

       while(low <= high) 
               mid = (low + high) / 2

               // change X[mid] to X[mid] - mid
               if(X[mid] - mid == 0)
                       return mid

               // change here too
               else if(X[mid] - mid < 0)
                       low = mid + 1;

               else
                       high = mid - 1;
       end while

       return -1 // no such index exists...return an invalid index.

end function