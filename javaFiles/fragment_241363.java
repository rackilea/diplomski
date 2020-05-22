val fullJsonObject = JObject()
val singleObject = containers.map { container =>
  val fullObj = fullJsonObject.merge(container)
  fullObj
}
fullJsonObject