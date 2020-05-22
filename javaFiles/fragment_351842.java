for(int i = 0; i < array1.length; i++) {
    for(int j = 0; j < array2.length; j++) { // <--- This loop
        calculations = ((array1[i] + array2[j]) % 10);
    }
    calculationsArray.add(calculations);
}