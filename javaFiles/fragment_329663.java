foreach(item i : S) {
   /* all other item except i1 and i */
   foreach(item i1 : S - {i}) {
       foreach(item i2 : S - {i, i1}) {
          .
          .
          .
          foreach(item in : S - {i, i2, .... in-1}) {
             /* permutation list */
             P = { i1, i2, ...., in-1, in }; 
          }
       }
   }
}