import java.io._
import scala.io._

Source.fromFile(new File("/tmp/log")).getLines.foldLeft(Map.empty[String, PrintWriter]) { 
    case (printers, line) =>
        val id = line.split(" ").head
        val printer = printers.get(id).getOrElse(new PrintWriter(new File(s"/tmp/log_$id")))
        printer.println(line)
        printers.updated(id, printer)
}.values.foreach(_.close)