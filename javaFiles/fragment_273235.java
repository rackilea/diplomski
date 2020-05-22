public static int[] join(int[] arr1,int[] arr2){
        int[] joinArr=new int[arr1.length + arr2.length];
        int i=0,j=0,k=0;
        while(i<arr1.length && j<arr2.length){  // coping from both the array while one of them is exhausted
            if( arr1[i]>arr2[j]){
                joinArr[k++]=arr1[i++]; // coping from arr1 and update the index i and k.
            }else if(arr1[i]<arr2[j]){
                joinArr[k++]=arr2[j++]; // coping from arr2 and update the index j and k.
            }else{
                joinArr[k++]=arr2[j++]; // coping from any of arr1  or arr2 and update the index i,j and k. 
                i++;
            }


        }  
        if(i<arr1.length){  // coping from  the array arr1 since arr2 is exhausted

             while(i<arr1.length ){
                 joinArr[k++]=arr1[i++];
             }
        }

        if(j<arr2.length){  // coping from  the array arr2 since arr1 is exhausted

             while(j<arr2.length ){
                 joinArr[k++]=arr2[j++];
             }
        }

        return Arrays.copyOf(joinArr, k);

    }