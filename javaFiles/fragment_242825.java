lowerCounter=higherCounter=0;
for(int i = 0; i < numbers.length; i++) {
   if (numbers[i] <= 499) {
       numbersLow[lowerCounter++] = numbers[i];
   } else {
       numbersHigh[higherCounter++] = numbers[i];
   }
}