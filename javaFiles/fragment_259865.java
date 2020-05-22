import java.io.File
import scala.util._
def walk(f: File, callback: File => Unit, pick: File => Boolean = _ => true) {
  Try {
    val (dirs, fs) = f.listFiles.partition(_.isDirectory)
    fs.filter(pick).foreach(callback)
    dirs.par.foreach(f => walk(f, callback, pick))
  }
}