while (scanner.hasNextLine())
{
  stocksList.add(scanner.nextDouble());
}
stocks.close();

for(int i=0;i<stocksList.size();i++)
{
  if (i + 1 < stocksList.size())  
  { // in other case we cant say is it count up or count down
    if (stocksList.get(i) > stocksList.get(i+1))
    {
        countUp ++;
    }
    else
    {
        countDown ++;
    }
  }

  ... skiped code ...

  System.out.printf(num + "%8.3f",stocksList.get(i));
  System.out.println(" " + choice+ " " + countUp + " " +countDown); 
}