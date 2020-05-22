public double spendMoney(double s)
{
  if(spend > creditLimit || spend > creditLimit - creditBalance)
  {
     System.out.println("Credit Limit Exceeded");
  }
  else
  {
     spend += s;
  }
  return spend; 
}