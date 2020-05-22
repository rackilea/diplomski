// set up new array L'
int Lprime[N+1];
int leftmost = 1;
int rightmost = N;
bool isReversed = false;

for (int i = 1; i <= N; i++) {
    if (S[i] == 'R') {
        // negate isReversed
        isReversed = !isReversed;
    }

    if (isReversed) {
        Lprime[i] = L[rightmost];
        rightmost = rightmost - 1;
    } else {
        Lprime[i] = L[leftmost];
        leftmost = leftmost - 1;
    }
}

int multiplicativeConstant = 1;
int additiveConstant = 0;
// factor out A % C and B % C
int aModC = A % C;
int bModC = B % C;
for (int i = 1; i <= N; i++) {
    if (S[i] == 'A') {
        additiveConstant = (additiveConstant + aModC) % C;
    } else if (S[i] == 'M') {
        multiplicativeConstant = (multiplicativeConstant * bModC) % C;
        // need to multiply all the constants by B as well
        additiveConstant = (additiveConstant * bModC) % C;
    }
    Lprime[i] = ((multiplicativeConstant * (Lprime[i] % C)) % C + additiveConstant) % C;
}
// print Lprime