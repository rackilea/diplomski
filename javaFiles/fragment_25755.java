int x = 3;  // chunk size
int len = bytes.length;
int counter = 0;

for (int i = 0; i < len - x + 1; i += x)
    newArray[counter++] = Arrays.copyOfRange(bytes, i, i + x);

if (len % x != 0)
    newArray[counter] = Arrays.copyOfRange(bytes, len - len % x, len);