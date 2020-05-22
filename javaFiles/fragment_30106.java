scala> object Test { class A; object A { println("A.init") }}        
defined module Test

scala> new Test.A
res3: Test.A = Test$A@3b48a8e6

scala> Test.A
A.init
res4: Test.A.type = Test$A$@6e453dd5