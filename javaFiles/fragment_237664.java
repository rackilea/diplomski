final byte[] original = ...;
final byte[] transformed = new byte[original.length * 2];
int len = 0;

for (int i = 0; i < original.length; i++) // for each original byte ...
{
  transformed[len] = original[i];         // copy the byte
  len++;                                  // track the number of transformed bytes written

  if (original[i] == (byte) '\r')         // if this is a \r ...
  {
    if (i + 1 < original.length &&        // ... and there is a character that follows ...
        original[i+1] != (byte) '\n')     // ... and that character is not a \n ...
    {
      transformed[len] = (byte) '\n';     // ... insert a \n
      len++;                              // ... being sure to track the number of bytes written
    }
  }
}

final byte[] result = new byte[len];              // prepare an exact sized array
System.arrayCopy(transformed, 0, result, 0, len); // and copy the transformed bytes into it