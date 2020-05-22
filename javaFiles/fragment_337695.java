byte[] temp = null;
  temp  = foo(temp);

  byte[] foo(byte[] temp)
  {    temp = new byte[some_const];
      //fill array
      return temp;
  }