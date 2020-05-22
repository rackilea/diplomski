$ scala
Welcome to Scala version 2.11.2 (Java HotSpot(TM) 64-Bit Server VM, Java 1.8.0_05).
Type in expressions to have them evaluated.
Type :help for more information.

scala> object Days extends Enumeration { val M,T,W,Th,F,Sa,S = Value }
defined object Days

scala> val ds = (2 to 5).toArray
ds: Array[Int] = Array(2, 3, 4, 5)

scala> Days.values filter (ds contains _.id)
res0: Days.ValueSet = Days.ValueSet(W, Th, F, Sa)