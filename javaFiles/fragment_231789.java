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
        leftmost = leftmost + 1;
    }
}