// add elements missing from first array
while (aCount < a.length) {
     c[cIndex] = a[aCount];
     cIndex++;
     aCount++;
}

// add elements missing from second array
while (bCount < b.length) {
     c[cIndex] = b[bCount];
     cIndex++;
     bCount++;
}