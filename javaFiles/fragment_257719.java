public static int isGreater(int limit, int[] data){
int overLimit = 0; 
      for(int k = 0; k < data.length; k++){
        if (data[k] > limit) overLimit++;
      }
return (overLimit/data.length)*100;
}