String secondByte = "13";
String secondByteBits = new BigInteger(secondByte, 16).toString(2);
String[] secondByteBitArray = secondByteBits.split("(?<=\\G.{1})");     
for(int i=0; i<secondByteBitArray.length/2; i++){ // note the division
    int i2 = secondByteBitArray.length-i-1;
    // swap
    String aux = secondByteBitArray[i];
    secondByteBitArray[i] = secondByteBitArray[i2];
    secondByteBitArray[i2] = aux;
}