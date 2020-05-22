1                                                                                                                                                                                                                  
----------------------------------------------------------------------------

SQL0100W  No row was found for FETCH, UPDATE or DELETE; or the result of
      a query is an empty table.

Explanation: 

One of the following conditions is true:

*  No row was found that meets the search conditions specified in an
   UPDATE or DELETE statement.

*  The result of a SELECT statement was an empty table.

*  A FETCH statement was executed when the cursor was positioned after
   the last row of the result table.

*  The result of the SELECT used in an INSERT statement is empty.

No data was retrieved, updated, or deleted.

User response: 

No action is required. Processing can continue.

sqlcode: +100

sqlstate: 02000



  1 record(s) selected.