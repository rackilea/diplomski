key= list[i];
        j = i-1;
       int k=i;
        while(j>=0&& list[k].compareTo(list[j]) < 0 )
        {
            temp = list[j];
            list[j] = list[j+1];
            list[j+1] = temp;
            j--;
        k--;
        }