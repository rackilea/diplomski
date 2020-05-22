package bigmethod

import scala.language.experimental.macros
import scala.reflect.macros.Context

object BigMethod {
  // For this simplified example we'll just make some data up.
  //final val size = 700
  final val size = 7000
  val mapping = List.tabulate(size)(i => (i, i + 1))

  def lookup(i: Int): Int = macro lookup_impl
  def lookup_impl(c: Context)(i: c.Expr[Int]): c.Expr[Int] = {

    def compilable[T](x: c.Expr[T]): Boolean = {
      import scala.reflect.runtime.{ universe => ru }
      import scala.tools.reflect._
      //val mirror = ru.runtimeMirror(c.libraryClassLoader)
      val mirror = ru.runtimeMirror(getClass.getClassLoader)
      val toolbox = mirror.mkToolBox()
      val importer0 = ru.mkImporter(c.universe)
      type ruImporter = ru.Importer { val from: c.universe.type }
      val importer = importer0.asInstanceOf[ruImporter]
      val imported = importer.importTree(x.tree)
      val tree = toolbox.resetAllAttrs(imported.duplicate)
      try {
        toolbox.compile(tree)
        true
      } catch {
        case t: Throwable =>
          Console println s"Error is $t"
          false
      }
    }
    import c.universe._

    val switch = reify(new scala.annotation.switch).tree
    val cases = mapping map {
      case (k, v) => CaseDef(c.literal(k).tree, EmptyTree, c.literal(v).tree)
    }

    //val res = c.Expr(Match(Annotated(switch, i.tree), cases))
    val res = c.Expr(Match(i.tree, cases))

    // before returning a potentially huge tree, try compiling it
    //import scala.tools.reflect._
    //val x = c.Expr[Int](c.resetAllAttrs(res.tree.duplicate))
    //val y = c.eval(x)
    if (!compilable(res)) c.abort(c.enclosingPosition, "You ask too much of me.")

    res
  }
}