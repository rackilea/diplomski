seq1 = AABB
seq2 = ACDDABB



len1 = length of seq1
len2 = length of seq2
// 0-indexed arrays
dp[0..len1-1][0..len2-1][0..3] = -1;
bool solve ( char seq1[], char seq2[], int i1, int i2, int lim) {
    if (i1 == len1-1) { // First sequence is finished
        if (len2-1-i2 <= 3-lim) return true; // If number of characters in second sequence are less than limit left
        return false;
    }
    // If we already know what happens for these indexes and limit
    if (dp[i1][i2][lim] != -1) return dp[i1][i2][lim];
    if (seq1[i1] == seq2[i2]) { // Ok
        dp[i1][i2][lim] = solve(seq1, seq2, i1+1, i2+1, lim); // Check for next character
        return dp[i1][i2][lim];
    }
    else { 
        // Maximum allowed limit is 3, so skip characters accordingly
        bool r1,r2,r3;
        r1 = r2 = r3 = false;
        if (lim < 3)
            r1 = solve(seq1, seq2, i1, i2+1, lim+1); // One char skipped in second seq.
        if (lim < 2) 
            r2 = solve(seq1, seq2, i1, i2+2, lim+2); // Two char skipped in second seq.
        if (lim < 1)
            r3 = solve(seq1, seq2, i1, i2+3, lim+3); // Three char skipped in second seq.
        dp[i1][i2][lim] = r1 || r2 || r3; // If any of them is true, then it matches
        return dp[i1][i2][lim]; 
    }
}