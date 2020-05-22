private int stored = 0;
public int compareAndSwap(int expectedValue , int newValue)

   if(expectedValue == stored)
       stored = newValue;

   return stored;
}