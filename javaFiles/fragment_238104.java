public static void insert(int val,int[] arr){
      int i;
      for(i=0;i<arr.length-1;i++){
        if(arr[i]>val)
          break;
      }
      for(int k=arr.length-2; k>=i; k--){
        arr[k+1]=arr[k];            
      }
      arr[i]=val;
      System.out.println(Arrays.toString(arr));

    }