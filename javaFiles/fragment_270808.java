scala> val jmap2 = {              
     |   val x = new java.util.HashMap[Int,String]  
     |   for ((k,v) <- List(1->"Howdy",2->"partner")) x.put(k,v)
     |   x
     | }
jmap2: java.util.HashMap[Int,String] = {1=Howdy, 2=partner}