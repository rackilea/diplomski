String[][] codesNear = new String[8][4];
for(int i = 0; i < 8; i++) {
    codesNear[i][0] = bitString(i);
    codesNear[i][1] = bitString(i ^ 1);
    codesNear[i][2] = bitString(i ^ 2);
    codesNear[i][3] = bitString(i ^ 4);
}