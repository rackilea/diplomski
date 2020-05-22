int currSum = 0;
int oddCount = 0;
for(int i = 1; currSum + i <= num; i+=2) {
   currSum += i;
   oddCount++;
}