scala> val jmap3 = new java.util.HashMap[Int,String] { 
     |   put(1,"Yo"); put(2,"bro")
     | }
jmap3: java.util.HashMap[Int,String] = {1=Yo, 2=bro}

scala> jmap3.getClass.getName
res0: java.lang.String = $anon$1

scala> jmap3.getClass.getSuperclass.getName
res1: java.lang.String = java.util.HashMap