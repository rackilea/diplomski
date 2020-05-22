import java.nio.file.attribute.BasicFileAttributes
import java.nio.file._

import scala.collection.mutable.ArrayBuffer

val files = ArrayBuffer.empty[Path]

val root = Paths.get("/path/to/your/directory")

Files.walkFileTree(root, new SimpleFileVisitor[Path] {
  override def visitFile(file: Path, attrs: BasicFileAttributes) = {
    if (file.getFileName.toString.endsWith(".txt")) {
      files += file
    }
    FileVisitResult.CONTINUE
  }
})

files.foreach(println)