boolean swapped = true;
int j = 0;
int tmp;
while (swapped) {
    swapped = false;
    j++;
    for (int i = 0; i < testArray.length - j; i++) {                                       
          if (testArray[i] > testArray[i + 1]) {                          
                tmp = testArray[i];
                testArray[i] = testArray[i + 1];
                testArray[i + 1] = tmp;
                swapped = true;
          }
    }                
}