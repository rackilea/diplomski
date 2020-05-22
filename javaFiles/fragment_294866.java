public boolean equals(Object o) {
  if (o == this) {
    return true;
  }

  if (!(o instanceof BobTheBuilder)) {
    return false:
  }

  BobTheBuilder bob = (BobTheBuilder) o; //guaranteed to succeed

  return Arrays.equals(bob._arrayObject, _arrayObject)
    && bob._integerBob == _integerBob;
}