class Initializer(private val root: File) {

  val loader = URLClassLoader(
      listOf(root.toURI().toURL()).toTypedArray(),
      this::class.java.classLoader)

  @Suppress("UNCHECKED_CAST") 
  inline fun <reified T> loadCompiledObject(clazzName: String): T? 
      = loader.loadClass(clazzName).kotlin.objectInstance as T

  @Suppress("UNCHECKED_CAST") 
  inline fun <reified T> createInstance(clazzName: String): T? 
      = loader.loadClass(clazzName).kotlin.createInstance() as T

}