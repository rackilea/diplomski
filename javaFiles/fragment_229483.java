import scala.collection.mutable.{HashMap ⇒ MHMap,  SynchronizedMap}
import scala.reflect.{ClassTag, classTag}

class Service

case class Foo() extends Service
case class Bar() extends Service

object Service {
  object pendingServices {
    private val backing = (new MHMap[String, Map[Class[_], Service]] with SynchronizedMap)
        .withDefaultValue(Map.empty)

    def update[T <: Service : ClassTag](name: String, service: T): Unit =
      backing(name) += classTag[T].runtimeClass → service

    def apply[T <: Service : ClassTag](name: String): T =
      backing(name)(classTag[T].runtimeClass).asInstanceOf[T]
  }
}