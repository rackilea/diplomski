if (T())
{
   if (c == '+' || c == '-')
   {  
      ++c;
      return E();
   }
   return true;
}
return false;