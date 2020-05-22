if( left.isEmpty() && right.isEmpty()) v = k; // initial

else 
{
    if( less(k, v) && (left.size() < right.size() + 1))
    {
        left.insert(k);
    }
    else if( great(k, v) && (right.size() < left.size() + 1)) 
    {
        right.insert(k);
    }
    else 
    {
       if( left.size() == right.size() + 1) 
       {
           right.insert(v);
           left.insert(k);
           v = (Key)left.max();
        }
        else 
        {
           left.insert(v);
           right.insert(k);
           v = (Key)right.min();
        }       
  }