import org.sonar.api.batch._
import org.sonar.api.resources._ 

object D {
  type R = Resource[T] forSome {type T <: Resource[_ <: AnyRef]}
  type S[T] = Resource[T] forSome {type T <: Resource[_ <: AnyRef]}
}

class D extends Decorator {
  def decorate(r: D.R, context: DecoratorContext) {}
  //def decorate(r: D.S[_], context: DecoratorContext) {} // compiles too
  def shouldExecuteOnProject(project: Project) = true
}