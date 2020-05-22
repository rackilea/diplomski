import play.api.inject.Injector
import javax.inject.Inject

class MyService @Inject() (injector: Injector) ={
    val myClassInstance = injector.instanceOf[MyClass]
    //do stuff
}