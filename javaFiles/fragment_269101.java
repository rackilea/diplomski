// WITHOUT MACROS (using enough of Scala's other features):
// Generates a query "SELECT NAME,PRICE FROM COFFEES IF SUP_ID = 101" 
for {
  c <- Coffees if c.supID === 101
  //                      ^ comparing Rep[Int] to Rep[Int]!
  // The above is Scala-shorthand for
  //     c <- Coffees if c.supID.===(Const[Int](101))
} yield (c.name, c.price)