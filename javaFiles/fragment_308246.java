// Count the occurrences of each bit

int[] bitcounts = new int[32];
for (int x=0; x<arr.length; ++x) {
    int val = arr[x];
    for (int bit=0; bit<32; ++bit) {
        if ((val & (1<<bit)) != 0) {
            bitcounts[bit]++;
        }
    }
}

// If a bit appears in n entries, then it appears in n(n+1)/2 pairs
// (counting the pair of each item with itself)

int result = 0;
for (int bit=0; bit<32; ++bit) {
   long pairs = ((long)bitcounts[bit]) * (bitcounts[bit]+1) / 2;
   result += ((int)pairs) * (1<<bit);
}
return result;