int aIILength = infiniteInteger.length;
int bIILength = anInfiniteInteger.infiniteInteger.length;
int carry = 0;
for(int f = 1; f <= aIILength || f <= bIILength || carry > 0; f++){
  int aTempNum;
  if (f <= aIILength) {
    aTempNum = infiniteInteger[aIILength - f];
  } else {
    aTempNum = 0;
  }
  int bTempNum;
  if (f <= bIILength) {
    bTempNum = anInfiniteInteger.infiniteInteger[bIILength - f];
  } else {
    bTempNum = 0;
  }
  result = aTempNum + bTempNum + carry;
  tempArray[tempArray.length - f] = result % 10;
  carry = result / 10;
}