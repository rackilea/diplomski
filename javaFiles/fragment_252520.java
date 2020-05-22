scala> res0.putIfAbsent("127.0.0.1", { println("evaluating mongod-process"); null } )
evaluating mongod-process
java.lang.NullPointerException
  at java.util.concurrent.ConcurrentHashMap.putVal(ConcurrentHashMap.java:1011)
  at java.util.concurrent.ConcurrentHashMap.putIfAbsent(ConcurrentHashMap.java:1535)
  ... 29 elided