int p = 0;
for (int i = 0 ; i < queue1.length || i < queue2.length ; i++) {
    if (i < queue1.length) {
        mergeQ[p++] = queue1[i];
    }
    if (i < queue2.length) {
        mergeQ[p++] = queue2[i];
    }
}