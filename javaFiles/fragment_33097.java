Builder$.MODULE$.apply()
   .withProp1(10, Builder$.MODULE$.unassigned())
   .withProp2(20, Builder$.MODULE$.unassigned())
   .withProp3(30, Builder$.MODULE$.unassigned())
   // ...
   .build(Builder$.MODULE$.assigned(), 
          Builder$.MODULE$.assigned(), 
          Builder$.MODULE$.assigned(), 
          //...
         );