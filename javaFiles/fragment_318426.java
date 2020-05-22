val gson: Gson = new GsonBuilder().setPrettyPrinting().enableComplexMapKeySerialization().create()
val finalSubstitutionData: util.LinkedHashMap[String, AnyRef] = new util.LinkedHashMap[String, AnyRef]()

javaObjectLevelSubs.forEach{
  case (k: String, v: String) => finalSubstitutionData.put(k, v)
  case (k: String, a) => a match {case l: List[_] => finalSubstitutionData.put(k, l.map(gson.toJsonTree).asJava)}
}