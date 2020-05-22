short s = -124;
  char c = 124; // OK, no compile time error
  char d = -124; // NOT OK, compile time error since char cannot hold -ve values
  char e = s; // NOT OK, compile time error since a short might have -ve values which char won't be able to hold
  char f = (char)s; // OK, type casting. The negative number -124 gets converted to 65412 so that char can hold it
  System.out.println((short)f); // -124, gets converted back to a number short can hold because short won't be able to hold 65412
  System.out.println((int)f); // 65412, gets converted to 65412 because int can easily hold it.