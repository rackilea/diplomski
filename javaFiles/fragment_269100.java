val coffees : List[Coffee] = // gotten from somewhere

// get from this list a list of (name, price) pairs also filtering on some condition
for {
  c <- coffees if c.supID == 101
  //                      ^ comparing an Int to an Int - normal stuff.
} yield (c.name, c.price)

// For Java programmers, the above is Scala's syntactic sugar for
coffees.filter(c => c.supId == 101).map(c => (c.name, c.price))