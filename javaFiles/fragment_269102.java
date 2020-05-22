// WITH MACROS:
// Generates a query "SELECT NAME,PRICE FROM COFFEES IF SUP_ID = 101" 
for {
  c <- coffees if c.supID == 101
  //                      ^ comparing Int to Int!
} yield (c.name, c.price)