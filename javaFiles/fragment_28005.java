private static void merge(int[] a, int from, int mid, int to) {
        final int begin = from, mitte = mid, end = to;

        int[] B = new int[end-begin+1];
        int k=0;
        int i = begin, j = mitte+1;
        while(i<=mid&&j<=end)
            if(a[i]<=a[j]){
                B[k++] = a[i];
                i++;
            } else {
                B[k++] = a[j];
                j++;
            }
        //in case i remained stationary
        while(i<=mid)
            B[k++] = a[i++];

        //in case j remained stationary
        while(j<=end)
            B[k++] = a[j++];

        //Now copy the array
        i=0;
        for(k=begin;k<=end;++k)
         a[k]=B[i++];
    }