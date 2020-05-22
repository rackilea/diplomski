int multiplicativeConstant = 1;
int additiveConstant = 0;
for (int i = 1; i <= N; i++) {
    if (S[i] == 'A') {
        additiveConstant = (additiveConstant + (A % C)) % C;
    } else if (S[i] == 'M') {
        multiplicativeConstant = (multiplicativeConstant * (B % C)) % C;
        // need to multiply all the constants by B as well
        additiveConstant = (additiveConstant * (B % C)) % C;
    }
    Lprime[i] = ((multiplicativeConstant * (Lprime[i] % C)) % C + additiveConstant) % C;
}