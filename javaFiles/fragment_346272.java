scala> cfig.root()
res74: com.typesafe.config.ConfigObject = SimpleConfigObject({"root":{"value1":1,"value2":2,"values":{"dynamic1":{"static1":10,"static2":"test"},"dynamic2":{"static1":10,"static2":"test"}}}})

scala> val c2 = cfig.getObject("root")
c2: com.typesafe.config.ConfigObject = SimpleConfigObject({"value1":1,"value2":2,"values":{"dynamic1":{"static1":10,"static2":"test"},"dynamic2":{"static1":10,"static2":"test"}}})

scala> c2.entrySet.size
res72: Int = 3

scala> c2.keySet.toSet
res73: scala.collection.immutable.Set[String] = Set(value2, value1, values)