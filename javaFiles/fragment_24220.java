@Override
protected String getString(int index) {
  if (index == 0) {
    return null;
  }
  // index is 1-based
  assert (index > 0);
  assert (index <= stringTable.length);
  return stringTable[index - 1];
}