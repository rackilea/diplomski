public static BitString decimalToUnsigned(int n, int size)
{
  // ...
  BitString bitString = new BitString(size);
  // ... loops, logic, etc. all to be put in here; when you're ready to
  // access the bits array, use:
  bitString.bits[index] = false;
  // ...
  // then when you're ready to return your BitString object, just:
  return bitString;
}