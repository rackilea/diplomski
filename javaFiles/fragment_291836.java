for( int inputIndex = 0, bucketIndex = 0; bucketIndex < bucketsOut.length;
          bucketIndex++ ) 
  {
     while( bucketsOut[bucketIndex].peekFirst() != null &&
             inputIndex < input.length ) 
     {
        input[inputIndex++] = bucketsOut[bucketIndex].pollFirst();
     }
  }