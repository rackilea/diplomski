object MyObject {
  private def instance = Play.current.injector.instanceOf[MyObject]
  def myMethod(param: String): String =
    instance.myMethod(param)
}

class MyObject @Inject() (wsClient: WSClient) {
  def myMethod(param: String): String = 
   // foo
}