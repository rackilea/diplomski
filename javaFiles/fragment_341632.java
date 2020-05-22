if (arr[i] != arr[i+1]) {
    if (maxsize < i + 1 - j + 1) {
        maxsize = i + 1 - j + 1;
        startindex = j;       
    }
} else {
    j = i + 1;
}