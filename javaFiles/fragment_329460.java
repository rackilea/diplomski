int maxFrequency = 0;
int index = 0;
for(int i = 0; i < 10; ++i){
   if(frequency[i] > maxFrequency){
     maxFrequency = frequency[i];
     index = i;
    }
  }
System.out.println("The highest occuring digit is " + index + " occuring " + maxFrequency + " times(s)");