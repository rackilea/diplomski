while (scanner.hasNextLine())
{
  stocksList.add(scanner.nextDouble());
}
stocks.close();

for(int i=0;i<stocksList.size(); i++)
{
  System.out.printf(num + "%8.3f",stocksList.get(i));
}

for(int i=0;i<stocksList.size() - 1 ;i++)
{
  ... skiped code ...
}