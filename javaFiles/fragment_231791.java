int multiplicativeConstant = 1;
int additiveConstant = 0;
for (int i = 1; i <= N; i++) {
    if (S[i] == 'A') {
        additiveConstant += A;
    } else if (S[i] == 'M') {
        multiplicativeConstant *= B;
        // need to multiply all the constants by B as well
        additiveConstant *= B;
    }
    Lprime[i] = multiplicativeConstant * Lprime[i] + additiveConstant;
}