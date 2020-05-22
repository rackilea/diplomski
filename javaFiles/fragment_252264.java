for (i=2; i < number; i++)
        {
            if(isPrime(i))
            {
                 if( number % i == 0)
                 {
                     factorArray.add(i);                    
                 }
            }   
        }