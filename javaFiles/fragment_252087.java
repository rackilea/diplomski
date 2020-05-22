import javax.inject.Inject

class MyObjFactory @Inject()(ctr: ContainerRequestContext) extends Factory[MyObj] {

  private final val context: ContainerRequestContext = ctr

  override def provide(): MyObj = context.getProperty("customObj").asInstanceOf[MyObj]

  override def dispose(obj: MyObj): Unit = {}

}