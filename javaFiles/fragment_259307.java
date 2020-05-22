public static int sumDivisor (int start, int end){
int value = 0;
    while (start % 5 != 0) {            
        start++;
    }
for(int i = start;i <= end;i += 5){
  value += i;    
}
return value;