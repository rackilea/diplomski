val ent = new Entity
  ent.getClass.getMethods
    .filter (m => m.getName.startsWith("get") && m.getName != "getClass")
    .filter (m => m.getParameterTypes.size == 0)
    .foreach (m => m.invoke(ent) match {
      case null => null

      case s: java.util.Collection[_] if doesMethodReturnGenericSubtype(ent.getClass,
        m.getName, classOf[java.lang.String]) => {

        println(s"Found list of strings in ${m.getName}, the values are ${s.toList}")
      }

      case s: java.util.Collection[_] if doesMethodReturnGenericSubtype(ent.getClass,
        m.getName, classOf[SubEntity]) => {

        println(s"Found list of SubEntity in ${m.getName}")
      }

      case x  => println(s"Unknown ${m.getName} in ${x.getClass.getName}")
  })