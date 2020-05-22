for(int i=0;i<s.length(); i++) { // - executed N/2 times
        int count = 0;               // - executed N/2 times
        for(int j=s.length()-1;j>=0; j--) {  // Executed (n/2 * n/2 )
            if(s.charAt(i) == s.charAt(j)) {  // Executed (n/2 * n/2 ) 
                count++;                      // Executed 1 time 
            }
        }
        if(count == 1) {                      //Evaluated N/2 times
            return s.charAt(i);               // Executed 1 time
        }
    }
    return '_';

Total = N/2 + N/2 + 2(N/2*N/2) + 1
= N^2/2 + N + 1