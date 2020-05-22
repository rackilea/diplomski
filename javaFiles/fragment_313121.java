public bool hasEight(int number)
{
      while(number > 0)
      {
          if(number % 10 == 8)
              return true;

          number=number/10;
      }
      return false; 
}