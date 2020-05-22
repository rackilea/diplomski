int numBit = 3;// or whatever number of bits up to the largest 2^numBit that can be stored in int. 
int numCombinations = 1<<numBits;//2^numBits (here numCombinations == 8)
String[][] codesNear = new String[numCombinations][numBits+1];
for(int i = 0; i < numCombinations; i++) {
    codesNear[i][0] = bitString(i,numBits);
    for(int j = 0; j < numBits; j++) {
        codesNear[i][j+1] = bitString(i ^ (1<<j),numBits);
    }
}