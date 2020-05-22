for ( int i=0 ; i<=getRowCount() ; i++)
         Integer balancevalue = (Integer)getValueAt(i,2));
         String accnum = (String)getValueAt(i,1);

         int a = Integer.parseInt(accnum); // parse String to int
         int b = balancevalue.intValue();  // get primitive value of Integer wrapper

         if( a == account ) { // we find the account number.  
             b= b + amount ;  // add the amount to the balance.

             // create new Integer (is an Object)
             Integer newBalance = new Integer(b);

             // store in the data array
             data[row,2] = newBalance;