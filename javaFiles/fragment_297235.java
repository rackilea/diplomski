int[] array = { ........ }; // your values...
for ( int i=0; i < array.Length; i++ )
{
   int count = 1;
   int value = array[i];

   // Consume until different..
   while ( i+1 < array.Length && array[i] == array[i+1] )
   { 
       count++; 
       i++ 
   }

   Console.WriteLine("{0}:{1}", count, value);
}

// OR, as suggested by @jon  [done in my head, so could probably be improved a lot...]
int count = 0;
int oldValue = -1;
for ( int i=0; i<array.Length; i++ )
{
   int newValue = array[i];
   count = ( newValue != oldValue ) ? 1 : count+1;

   if ( i+1 >= array.Length || array[i+1] != newValue)
   {
      Console.WriteLine("{0}:{1}", count, newValue);
   }

   oldValue = newValue;
}