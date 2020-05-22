int index = arrA.length;
for (int i = 0; i < arrA.length; i++) {
    arrC[i] = arrA[i];
}
for (int i = 0; i < arrB.length; i++) {
    arrC[i + index] = arrB[i];    
}