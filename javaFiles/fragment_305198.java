sort the array: use Arrays.sort()
 int max_difference = Integer.MAXVALUE
int val1, val2;
for(i=0; i< array_size -1; ++i) {
 int x = array[i+1] - array[i];
 if(x <= max_difference) {
   max_difference = x;
   val1 = array[i];
   val2 = array[i+1];
 }
}