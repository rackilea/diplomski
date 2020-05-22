//current index i + sublen cannot exceed dna length

//portion of dna starting from i and going sublen characters has to equal subsequence

int countSubstring(String subsequence, String dna) {
    int count = 0;
    int sublen = subsequence.length();    // lenght of the subsequence
    for (int i = 0; i < dna.length(); i++){
        if ((i + sublen) < dna.length() && 
            dna.substring(i, i + sublen).equals(subsequence)){
            count = count + 1;
        }

    }
    return count;
}