int comparison = a[tmp].compareTo(x); // Let's just compare once...
if (comparison == 0) {
   return tmp;
}
// This was our last chance!
if (high == low) {
   return -1;
}
// If a[tmp] was lower than x, look later in the array. If it was higher than
// x, look earlier in the array.
return comparison < 0 ? find(a, x, tmp + 1, high) : find(a, x, low, tmp - 1);