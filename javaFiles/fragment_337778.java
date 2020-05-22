int tempTerm = term, termDigitCount = 0;
while(tempTerm > 0){
    termDigitCount++;
    tempTerm /= 10;
}

// 51 > 0 -> termDigitCount = 1
// 1 > 0 -> termDigitCount = 2
// 0 > 0 -> exit while loop