import org.apache.commons.io.FileUtils
import org.clapper.classutil.{ClassFinder, ClassInfo}
import scala.collection.JavaConverters._

def triggerFactories() {
  val jars = FileUtils.iterateFiles(new File("lib"), Array[String]("jar"), true).asScala.toList
  val classes = ClassFinder(jars).getClasses
  val factories = ClassFinder.concreteSubclasses("com.example.Factory", classes)

  factories.foreach { (factory: ClassInfo) =>
    companion[Factory](factory.name).register()
  }
}

def companion[T](name: String)(implicit man: Manifest[T]): T =
  Class.forName(name).getField("MODULE$").get(man.erasure).asInstanceOf[T]