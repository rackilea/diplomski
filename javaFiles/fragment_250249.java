temp = root;
childOne = temp.getChildOne();
childZero = temp.getChildZero();
while(childOne != null && childZero != null) {
  currentBit = bitArray.get(startPosition++);
  if (currentBit == 1) {
    temp = childOne;
  } else {
    temp = childZero;
  }
  childOne = temp.getChildOne();
  childZero = temp.getChildZero();
}