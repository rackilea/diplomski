public int maxProduct(int[]data) {
      Arrays.sort(data);//non-decreasing order
      int n = data.length;
      int result = 0; 
      for(int i = 0; i < (1 << n); i++){ 
          int a = 0;
          int b = 0;
          for(int j = n - 1; j >= 0; j--){
               if(((1 << j) & i) == 0){
                    a = a * 10 + data[j];
               }else{
                    b = b * 10 + data[j];
               }
          }
          result = Integer.max(result, a*b);
      }
      return result;
}