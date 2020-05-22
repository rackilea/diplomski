private void populateRandomPrimes()
{
    while (true){
      onePrimeValue = RandomPrime.getValue();

      do
      {
          secondPrimeValue= RandomPrime.getValue();
      }while(onePrimeValue == secondPrimeValue);

      BigInteger calcNum = new BigInteger(Integer.toString(onePrimeValue*secondPrimeValue));

      try
      {
          if (calcNum.isProbablePrime(20)){
              populateMultiplicativeForPlayer();
              return;
          }
      }
      catch (Exception io)
      {
          io.printStackTrace();
      }
    }
}