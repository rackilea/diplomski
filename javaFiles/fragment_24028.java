public int throwdice() //to calculate the dice value
  {
    int i = (int)(Math.random() * 100); // make note on your Casting.
    i = i % 13;
    return i;
  }