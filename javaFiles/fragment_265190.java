if(i<n1 && j<n2) {
    if(lWord[i].compareTo(rWord[j]) < 0) {
        word[k] = lWord[i];
        lineNumber[k] = lLineNum[i];
        i++;
    }else // HERE next 3 lines should be in a {} block
        word[k] = rWord[j];
    lineNumber[k] = rLineNum[j];
    j++;
}
else if(i<n1) {
    word[k] = lWord[i];
    lineNumber[k] = lLineNum[i];
    i++;
}else if(j<n2){
    word[k] = rWord[j];
    lineNumber[k] = rLineNum[j];
    j++;
}