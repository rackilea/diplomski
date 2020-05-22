scala> object Test { class A { A }; object A { println("A.init") }}
defined module Test

scala> new Test.A                                                  
A.init
res5: Test.A = Test$A@4e94a28e

scala> new Test.A
res6: Test.A = Test$A@30227d4e