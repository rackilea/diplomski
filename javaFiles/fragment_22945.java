Integer [][] complement ( Integer[][] m ){
     Integer[][] recurResult = recursiveComplement ( m );
     // recursion has finished
     return doSomething ( recurResult );
 }

 Integer[][] recursiveComplement( Integer[][] m ){
     if( endCondition(m) ) return m; // Checks if Recursion shall be ended.
     Integer[][] levelM = doComplementTransform(m);
     return recursiveComplement( levelM );
 }