int keyIndex = 0;
for (int j = 0; j < matrix.length; j++) {
    for (int k = 0; k < matrix.length; k++) {
        matrix[j][k] = Integer.parseInt(keys[keyIndex]); // Problematic line
             keyIndex = keyIndex + 1;
    }
}