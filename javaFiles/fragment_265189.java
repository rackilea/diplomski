static void merge(String[] word, int[] lineNumber, int p, int q, int r) {
    int n1 = q-p+1;
    int n2 = r-q;
    String[] lWord = new String[n1];
    String[] rWord = new String[n2];
    int[] lLineNum = new int[n1];
    int[] rLineNum = new int[n2];
    int i, j, k;

    for(i=0; i<n1; i++) {
        lWord[i] = word[p+i];
        lLineNum[i] = lineNumber[p+i];
    }

    for(j=0; j<n2; j++) {
        rWord[j] = word[q+j+1];
        rLineNum[j] = lineNumber[q+j+1];
    }

    i = 0; j = 0;
    for(k=p; k<=r; k++) {
        if(i<n1 && j<n2) {
            if(lWord[i].compareTo(rWord[j]) < 0) {
                word[k] = lWord[i];
                lineNumber[k] = lLineNum[i];
                i++;
            }else {
                word[k] = rWord[j];
                lineNumber[k] = rLineNum[j];
                j++;
            }
        } else if(i<n1) {
            word[k] = lWord[i];
            lineNumber[k] = lLineNum[i];
            i++;
        } else if(j<n2){
            word[k] = rWord[j];
            lineNumber[k] = rLineNum[j];
            j++;
        }
    }
}