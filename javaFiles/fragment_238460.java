int index2 = 0;
for (int i = 0; i < arrD.length; i++) {
    for (int k = 0; k < arrD.length; k++) {
        if (arrD[i] != arrD[k]) {
            arrE[index2] = arrD[i];
            index2++;
        }
    }
}