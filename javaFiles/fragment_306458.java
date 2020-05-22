while (left<right){
          int middle=(left+right)/2;
          if (temp>=a[middle])
              left=right+1;
          else
               right=middle;