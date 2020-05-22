int l = oldArray.length; // Cache length (some compilers might do this for you)
for (int i=0, j=0, k=0; i<l; i++) {
    if (set[k]==i) {
        k++;
    } else {
        newArr[j++] = oldArray[i];
    }
}